package com.example.mym.crowdfunding.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mym.crowdfunding.R;
import com.example.mym.crowdfunding.model.ProjectsEntity;
import com.example.mym.crowdfunding.util.ServerConnector;

import java.util.ArrayList;

/**
 * Created by Mert on 6/14/2016.
 */
public class ProjectsRecyclerAdapter extends RecyclerView.Adapter<ProjectsRecyclerAdapter.ProjectViewHolder> implements Filterable {
    private ArrayList<ProjectsEntity> projects;
    private Context context;

    public ProjectsRecyclerAdapter(ArrayList<ProjectsEntity> projectsEntities) {
        projects = new ArrayList<>(projectsEntities);
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.project_card, parent, false);

        return new ProjectViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        ProjectsEntity projectsEntity = projects.get(position);
        holder.title.setText(projectsEntity.getTitle());
        holder.price.setText(projectsEntity.getPrice() + "€");
        holder.funded.setText(projectsEntity.getSale_current() + "/"  + projectsEntity.getSale_minimum());
        holder.togo.setText(projectsEntity.get_days_togo());
        holder.progressBar.setProgress((projectsEntity.getSalePercentage()));
        Glide.with(context).load(ServerConnector.server_image_url + projectsEntity.get_poster_url()).crossFade().fitCenter()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public ProjectsEntity get(int position) {
        return projects.get(position);
    }

    public static class ProjectViewHolder extends RecyclerView.ViewHolder{
        protected TextView title;
        protected TextView price;
        protected TextView funded;
        protected TextView togo;
        protected ImageView image;
        protected ProgressBar progressBar;
        public ProjectViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.projectTitle);
            price = (TextView) itemView.findViewById(R.id.project_price);
            funded = (TextView) itemView.findViewById(R.id.project_funded);
            togo = (TextView) itemView.findViewById(R.id.project_togo);
            image = (ImageView) itemView.findViewById(R.id.project_poster_image);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBarCard);
        }
    }
}

