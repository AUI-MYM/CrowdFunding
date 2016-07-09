package com.example.mym.crowdfunding.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mym.crowdfunding.R;
import com.example.mym.crowdfunding.adapters.ProjectsRecyclerAdapter;
import com.example.mym.crowdfunding.listeners.OnTaskCompleted;
import com.example.mym.crowdfunding.listeners.RecyclerItemClickListener;
import com.example.mym.crowdfunding.model.ProjectsEntity;
import com.example.mym.crowdfunding.model.UsersEntity;
import com.example.mym.crowdfunding.util.Commons;
import com.example.mym.crowdfunding.util.Json2ObjectFactory;
import com.example.mym.crowdfunding.util.ServerConnector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DesignerActivity extends AppCompatActivity {
    private UsersEntity view_user;
    private ArrayList<ProjectsEntity> projectsEntities;
    private int number_of_projects;
    private int number_of_projects_finished;
    private ProjectsRecyclerAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer);
        setViewUser();
        setContentDetails();
        //todo set other designs of users,
        AsyncLoadDesignerContent asynctask = new AsyncLoadDesignerContent(new OnTaskCompleted() {
            @Override
            public void taskCompleted(Object object) {
                setContentDetailsAfterDataFetch();
            }
        });
        asynctask.execute();
    }

    private void setViewUser() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        if (getIntent().hasExtra(ProjectDetailActivity.designer_view_extra)) {
            String json = getIntent().getStringExtra(ProjectDetailActivity.designer_view_extra);
            view_user = gson.fromJson(json, UsersEntity.class);
        }
    }

    private void setContentDetails() {
        if (view_user != null) {
            ImageView avatar = (ImageView) findViewById(R.id.profile_view_avatar);
            Glide.with(this).load(ServerConnector.server_avatar_url + view_user.getUsers_id() + ".jpg").crossFade().fitCenter()
                    .into(avatar);
            TextView fullname = (TextView) findViewById(R.id.profile_name_text_view);
            fullname.setText(view_user.getFirstname() +  " " + view_user.getLastname());
            TextView city = (TextView) findViewById(R.id.profile_view_city);
            city.setText(view_user.getCity());
            TextView projects = (TextView) findViewById(R.id.profile_view_projects_number);
            projects.setText("projects: 1" );
            TextView realized = (TextView) findViewById(R.id.profile_view_realized_number);
            realized.setText("realized: 1" );
            TextView website = (TextView) findViewById(R.id.profile_view_website);
            website.setText(view_user.getWebsite());
            TextView shortbio = (TextView) findViewById(R.id.profile_view_bio);
            shortbio.setText(view_user.getAbout());
        }
    }

    private void setContentDetailsAfterDataFetch() {
        TextView projects = (TextView) findViewById(R.id.profile_view_projects_number);
        projects.setText("projects: "  + number_of_projects);
        TextView projects_finished = (TextView) findViewById(R.id.profile_view_realized_number);
        projects_finished.setText("projects: "  + number_of_projects_finished);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.project_list_designer_view);
        recyclerView.setHasFixedSize(true);
        rAdapter = new ProjectsRecyclerAdapter(projectsEntities);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ProjectsEntity project = rAdapter.get(position);
                Gson gson = new Gson();
                String json = gson.toJson(project, ProjectsEntity.class);
                Intent intent = new Intent(DesignerActivity.this, ProjectDetailActivity.class);
                intent.putExtra(Commons.project_detail, json);
                startActivity(intent);
            }
        }));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(rAdapter);
    }
    public class AsyncLoadDesignerContent extends AsyncTask<String, Void, Void> {
        private OnTaskCompleted onTaskCompleted;
        public AsyncLoadDesignerContent(OnTaskCompleted otc) {
            super();
            onTaskCompleted = otc;
        }
        @Override
        protected Void doInBackground(String... params) {
            number_of_projects = Json2ObjectFactory.getNumberOfProjects(view_user.getUsers_id());
            number_of_projects_finished = Json2ObjectFactory.getNumberOfFinishedProjects(view_user.getUsers_id());
            projectsEntities = Json2ObjectFactory.get_projects_by_user(view_user.getUsers_id());
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            onTaskCompleted.taskCompleted(null);
        }
    }
}
