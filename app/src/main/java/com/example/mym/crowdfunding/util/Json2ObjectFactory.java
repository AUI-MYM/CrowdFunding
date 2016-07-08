package com.example.mym.crowdfunding.util;

import android.util.Log;

import com.example.mym.crowdfunding.model.ProjectsEntity;
import com.example.mym.crowdfunding.model.UsersEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mert on 6/12/2016.
 */
public class Json2ObjectFactory {
    private final static String view_all_projects = "projects/view_projects_homepage";
    private final static String view_designer = "users/view_designer/";

    public static ArrayList<ProjectsEntity> get_all_projects_home_page() {

        ServerConnector sc = ServerConnector.getInstance();

        try {

            ArrayList<ProjectsEntity> projectsEntities = new ArrayList<>();
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            Type type = new TypeToken<ArrayList<ProjectsEntity>>() {
            }.getType();
            for (int offset = 0; true; offset++) {
                JSONObject json = sc.getJSONFromUrl(view_all_projects + "/" + offset);
                JSONArray jsonArray = json.getJSONArray("rows");
                if (jsonArray.length() == 0) break;
                ArrayList<ProjectsEntity> temp = new ArrayList<>();
                temp = gson.fromJson(jsonArray.toString(), type);
                projectsEntities.addAll(temp);
            }
            return projectsEntities;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static UsersEntity get_user_by_id(int id) {
        ServerConnector sc = ServerConnector.getInstance();

        try {

            ArrayList<UsersEntity> user;
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            Type type = new TypeToken<ArrayList<UsersEntity> >() {
            }.getType();
            JSONObject json = sc.getJSONFromUrl(view_designer + id);
            JSONArray jsonArray = json.getJSONArray("rows");
            user = gson.fromJson(jsonArray.toString(), type);
            return user.get(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
