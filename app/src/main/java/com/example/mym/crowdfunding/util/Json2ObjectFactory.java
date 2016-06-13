package com.example.mym.crowdfunding.util;

import android.util.Log;

import com.example.mym.crowdfunding.model.ProjectsEntity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mert on 6/12/2016.
 */
public class Json2ObjectFactory {
    private final static String view_all_projects = "projects/view_projects_homepage";

    public static ArrayList<ProjectsEntity> get_all_projects_home_page() {

        ServerConnector sc = ServerConnector.getInstance();
        //JSONObject json = sc.getJSONFromUrl(view_all_projects);
        JSONObject json = sc.getJSONFromUrl(view_all_projects);
        try {
            JSONArray jsonArray = json.getJSONArray("rows");
            Gson gson = new Gson();
            ArrayList<ProjectsEntity> projectsEntities = new ArrayList<>();
            projectsEntities = gson.fromJson(jsonArray.toString(),projectsEntities.getClass() );
            return projectsEntities;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
