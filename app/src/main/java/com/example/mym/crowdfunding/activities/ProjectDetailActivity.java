package com.example.mym.crowdfunding.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mym.crowdfunding.R;
import com.example.mym.crowdfunding.adapters.GalleryImageAdapter;
import com.example.mym.crowdfunding.listeners.OnTaskCompleted;
import com.example.mym.crowdfunding.model.ProjectsEntity;
import com.example.mym.crowdfunding.model.UsersEntity;
import com.example.mym.crowdfunding.util.Commons;
import com.example.mym.crowdfunding.util.Json2ObjectFactory;
import com.example.mym.crowdfunding.util.ServerConnector;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class ProjectDetailActivity extends AppCompatActivity {
    public static final String designer_view_extra = "com.example.projectdetail.designer.json";
    protected Gallery gallery;
    protected ImageView selectedImage;
    protected ProjectsEntity projectsEntity;
    protected UsersEntity designerUser;
    protected int imagePosition;
    protected ArrayList<Bitmap> projectImages;
    private ProgressDialog progressDialog;
    private int current_quantity = 1;
    protected EditText quantity_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_project_detail);
        setSupportActionBar(toolbar);
        setProjectFromIntent();
        setProgressDialogView();
        setLeftAndRightButtonListeners();
        setViewContent();
        AsyncLoadProjectDetailData asyncTask = new AsyncLoadProjectDetailData(new OnTaskCompleted() {
            @Override
            public void taskCompleted(Object object) {
                setGalleryView();
                setViewContentAfterFetchData();
            }
        });
        asyncTask.execute("IMAGE", "DESIGNER", "TEST");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setViewContent() {
        TextView price = (TextView) findViewById(R.id.project_detail_price);
        TextView funded = (TextView) findViewById(R.id.project_detail_funded);
        TextView togo = (TextView) findViewById(R.id.project_detail_togo);
        TextView title = (TextView) findViewById(R.id.designViewTitle);
        TextView description = (TextView) findViewById(R.id.description_text_view);

        title.setText(projectsEntity.getTitle());
        price.setText(projectsEntity.getPrice() + "€");
        funded.setText(projectsEntity.getSale_current() + "/" + projectsEntity.getSale_minimum());
        //togo.setText(projectsEntity.get_days_togo());
        togo.setText("3 days");
        description.setText(projectsEntity.getDescription());

        setSpinnerViewForSize();
        setQuantityButtons();
    }

    private void setQuantityButtons() {
        ImageButton down = (ImageButton) findViewById(R.id.quantity_button_down);
        ImageButton up = (ImageButton) findViewById(R.id.quantity_button_up);
        quantity_text = (EditText) findViewById(R.id.quantity_edit_text);
        quantity_text.setText(String.valueOf(current_quantity));
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_quantity--;
                current_quantity = (current_quantity > 0) ? current_quantity : 0;
                quantity_text.setText(String.valueOf(current_quantity));
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_quantity++;
                quantity_text.setText(String.valueOf(current_quantity));
            }
        });
    }

    private void setViewContentAfterFetchData() {
        TextView designerName = (TextView) findViewById(R.id.textViewDesignerName);
        TextView designerName2 = (TextView) findViewById(R.id.designer_name_detail);
        TextView designerWebsite = (TextView) findViewById(R.id.designer_website_detail);
        designerName.setText("by " + designerUser.getFirstname() + " " + designerUser.getLastname());
        designerName2.setText(designerUser.getFirstname() + " "+ designerUser.getLastname());
        designerWebsite.setText(designerUser.getWebsite());

        ImageView avatar_designer = (ImageView) findViewById(R.id.designer_avatar);
        Glide.with(this).load(ServerConnector.server_avatar_url + designerUser.getUsers_id() + ".jpg").crossFade().fitCenter()
                .into(avatar_designer);
        Button seeInfo = (Button) findViewById(R.id.designer_profile_view);
        seeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .create();
                Intent intent = new Intent(ProjectDetailActivity.this, DesignerActivity.class);
                intent.putExtra(designer_view_extra, gson.toJson(designerUser));
                startActivity(intent);
            }
        });
    }

    private void setLeftAndRightButtonListeners() {
        ImageButton left = (ImageButton) findViewById(R.id.project_detail_left_button);
        ImageButton right = (ImageButton) findViewById(R.id.project_detail_right_button);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePosition += 3;
                imagePosition %= projectImages.size();
                gallery.setSelection(imagePosition, true);
                selectedImage.setImageBitmap(projectImages.get(imagePosition));
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePosition++;
                imagePosition %= projectImages.size();
                gallery.setSelection(imagePosition, true);
                selectedImage.setImageBitmap(projectImages.get(imagePosition));
            }
        });
    }

    private void setGalleryView() {
        gallery = (Gallery) findViewById(R.id.gallery1);
        selectedImage = (ImageView) findViewById(R.id.imageView);
        selectedImage.setImageBitmap(projectImages.get(0));
        //ImageView frameImage = (ImageView) findViewById(R.id.imageViewFrame);
        //frameImage.getLayoutParams().width = selectedImage.getWidth();
        gallery.setSpacing(1);
        final GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(this, projectImages);
        gallery.setAdapter(galleryImageAdapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                //selectedImage.setImageResource(galleryImageAdapter.mImageIds[position]);
                selectedImage.setImageBitmap(projectImages.get(position));
                imagePosition = position;
            }
        });
    }

    private void setSpinnerViewForSize() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.size_array,R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
        spinner.setPrompt(getResources().getString(R.string.size_selection));
    }

    private void setProjectFromIntent() {
        String json = getIntent().getStringExtra(Commons.project_detail);
        Gson gson = new Gson();
        projectsEntity = gson.fromJson(json, ProjectsEntity.class);
    }

    private void setProgressDialogView() {
        //show a progress dialog
        progressDialog =
                ProgressDialog.show(this,
                        getResources().getString(R.string.loading),
                        getResources().getString(R.string.loading_single_project), true, false);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    public class AsyncLoadProjectDetailData extends AsyncTask<String, Void, Void> {
        private OnTaskCompleted onTaskCompleted;

        public AsyncLoadProjectDetailData(OnTaskCompleted otc) {
            super();
            onTaskCompleted = otc;
        }

        @Override
        protected Void doInBackground(String... params) {
            for (String param : params) {
                if (param.equals("IMAGE")) {
                    projectImages = ServerConnector.getInstance().
                            getImagesFromURLList(projectsEntity.getImageURIList());
                } else if (param.equals("DESIGNER")) {
                    designerUser = Json2ObjectFactory.get_user_by_id(projectsEntity.getProjects_users_id());
                }
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

}
