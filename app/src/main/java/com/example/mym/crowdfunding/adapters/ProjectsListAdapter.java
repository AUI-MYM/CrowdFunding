package com.example.mym.crowdfunding.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mym.crowdfunding.R;
import com.example.mym.crowdfunding.model.ProjectsEntity;
import com.example.mym.crowdfunding.util.ServerConnector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mert on 7/9/2016.
 */
public class ProjectsListAdapter extends ArrayAdapter<ProjectsEntity> {
    protected List<ProjectsEntity> projectsEntities;
    private Context context;

    public ProjectsListAdapter(Context context, int resource, List<ProjectsEntity> objects) {
        super(context, resource, objects);
        projectsEntities = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ProjectViewHolder holder = null;
        ProjectsEntity projectsEntity = projectsEntities.get(position);
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.project_card, parent, false);

            holder = new ProjectViewHolder(row);
            holder.title.setText(projectsEntity.getTitle());
            holder.price.setText(projectsEntity.getPrice() + "€");
            holder.funded.setText(projectsEntity.getSale_current() + "/"  + projectsEntity.getSale_minimum());
            holder.togo.setText(projectsEntity.get_days_togo());
            holder.progressBar.setProgress((projectsEntity.getSalePercentage()));
            Glide.with(context).load(ServerConnector.server_image_url + projectsEntity.get_poster_url()).crossFade().fitCenter()
                    .into(holder.image);
            row.setTag(holder);
        }
        return row;
    }

    public ProjectsEntity get(int position) {
        return projectsEntities.get(position);
    }

    public static class ProjectViewHolder {
        protected TextView title;
        protected TextView price;
        protected TextView funded;
        protected TextView togo;
        protected ImageView image;
        protected ProgressBar progressBar;
        public ProjectViewHolder(View itemView) {
            title = (TextView) itemView.findViewById(R.id.projectTitle);
            price = (TextView) itemView.findViewById(R.id.project_price);
            funded = (TextView) itemView.findViewById(R.id.project_funded);
            togo = (TextView) itemView.findViewById(R.id.project_togo);
            image = (ImageView) itemView.findViewById(R.id.project_poster_image);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBarCard);
        }
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
