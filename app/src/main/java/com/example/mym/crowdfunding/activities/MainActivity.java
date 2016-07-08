package com.example.mym.crowdfunding.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mym.crowdfunding.R;
import com.example.mym.crowdfunding.adapters.ProjectsRecyclerAdapter;
import com.example.mym.crowdfunding.listeners.RecyclerItemClickListener;
import com.example.mym.crowdfunding.model.ProjectsEntity;
import com.example.mym.crowdfunding.util.Commons;
import com.example.mym.crowdfunding.util.Json2ObjectFactory;
import com.example.mym.crowdfunding.listeners.OnTaskCompleted;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ProgressDialog progressDialog = null;
    private ArrayList<ProjectsEntity> projectsEntities;
    private ProjectsRecyclerAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo: back action reloads all the projects
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupProjectsView();
        AsyncLoadProjects asyncLoadProjects = new AsyncLoadProjects(new OnTaskCompleted() {
            @Override
            public void taskCompleted(Object object) {
                if (projectsEntities != null) {
                    loadRecyclerList(projectsEntities);
                }
            }
        });
        asyncLoadProjects.execute();

    }

    private void loadRecyclerList(ArrayList<ProjectsEntity> projectsEntities) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.project_list);
        recyclerView.setHasFixedSize(true);

        rAdapter = new ProjectsRecyclerAdapter(projectsEntities);

                    recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            ProjectsEntity project = rAdapter.get(position);
                            Gson gson = new Gson();
                            String json = gson.toJson(project, ProjectsEntity.class);
                            Intent intent = new Intent(MainActivity.this, ProjectDetailActivity.class);
                            intent.putExtra(Commons.project_detail, json);
                            startActivity(intent);
                        }
                    }));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(rAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
/*
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class AsyncLoadProjects extends AsyncTask<String, Void, Void> {
        private OnTaskCompleted onTaskCompleted;
        public AsyncLoadProjects(OnTaskCompleted otc) {
            super();
            onTaskCompleted = otc;
        }
        @Override
        protected Void doInBackground(String... params) {
            projectsEntities =  Json2ObjectFactory.get_all_projects_home_page();
            try {
                //To see the loading effect
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (progressDialog != null) {
                progressDialog.dismiss();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            onTaskCompleted.taskCompleted(null);
        }
    }

    private void setupProjectsView() {
        //show a progress dialog
        progressDialog =
                ProgressDialog.show(this,
                        getResources().getString(R.string.loading),
                        getResources().getString(R.string.loading_projects), true, false);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }
}
