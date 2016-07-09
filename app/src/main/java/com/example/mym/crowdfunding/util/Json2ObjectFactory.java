package com.example.mym.crowdfunding.util;

import android.util.Log;

import com.example.mym.crowdfunding.model.CommentEntity;
import com.example.mym.crowdfunding.model.ProjectsEntity;
import com.example.mym.crowdfunding.model.UsersEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mert on 6/12/2016.
 */
public class Json2ObjectFactory {
    private final static String view_all_projects = "projects/view_projects_homepage";
    private final static String view_designer = "users/view_designer/";
    private final static String number_of_projects_published = "projects/num_projects_published/";
    private final static String number_of_projects_finished = "projects/num_projects_finished/";
    private final static String view_projects_by_user = "projects/view_projects_by_user/";
    private final static String view_cart_by_user = "orders/view_preorder_by_users_id/";
    private final static String view_comment_by_project = "comment/view_comments/";
    private final static String view_address_by_id = "users/view_address_by_id/";
    private final static String login_url = "users/login/";
    private final static String register_url = "users/signup/";

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
            Type type = new TypeToken<ArrayList<UsersEntity>>() {
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

    public static int getNumberOfProjects(int id) {
        ServerConnector sc = ServerConnector.getInstance();
        try {
            JSONObject json = sc.getJSONFromUrl(number_of_projects_published + id);
            return json.getInt("row");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getNumberOfFinishedProjects(int id) {
        ServerConnector sc = ServerConnector.getInstance();
        try {
            JSONObject json = sc.getJSONFromUrl(number_of_projects_finished + id);
            return json.getInt("row");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<ProjectsEntity> get_projects_by_user(int id) {

        ServerConnector sc = ServerConnector.getInstance();
        try {

            ArrayList<ProjectsEntity> projectsEntities = new ArrayList<>();
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            Type type = new TypeToken<ArrayList<ProjectsEntity>>() {
            }.getType();
            JSONObject json = sc.getJSONFromUrl(view_projects_by_user + id);
            JSONArray jsonArray = json.getJSONArray("rows");
            projectsEntities = gson.fromJson(jsonArray.toString(), type);
            return projectsEntities;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<ProjectsEntity> get_cart_by_user(int id) {

        ServerConnector sc = ServerConnector.getInstance();

        try {

            ArrayList<ProjectsEntity> projectsEntities = new ArrayList<>();
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            Type type = new TypeToken<ArrayList<ProjectsEntity>>() {
            }.getType();
            JSONObject json = sc.getJSONFromUrl(view_cart_by_user + id);
            JSONArray jsonArray = json.getJSONArray("rows");
            projectsEntities = gson.fromJson(jsonArray.toString(), type);
            return projectsEntities;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    //

    public static ArrayList<CommentEntity> get_comment_by_project(int id) {

        ServerConnector sc = ServerConnector.getInstance();

        try {

            ArrayList<CommentEntity> commentEntities = new ArrayList<>();
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            Type type = new TypeToken<ArrayList<CommentEntity>>() {
            }.getType();
            JSONObject json = sc.getJSONFromUrl(view_comment_by_project + id);
            JSONArray jsonArray = json.getJSONArray("rows");
            commentEntities = gson.fromJson(jsonArray.toString(), type);
            return commentEntities;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    //

    public static ArrayList<ProjectsEntity> get_address_by_id(int id) {

        ServerConnector sc = ServerConnector.getInstance();

        try {

            ArrayList<ProjectsEntity> projectsEntities = new ArrayList<>();
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            Type type = new TypeToken<ArrayList<ProjectsEntity>>() {
            }.getType();
            JSONObject json = sc.getJSONFromUrl(view_address_by_id + id);
            JSONArray jsonArray = json.getJSONArray("rows");
            projectsEntities = gson.fromJson(jsonArray.toString(), type);
            return projectsEntities;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UsersEntity login_user(String email, String password) {

        ServerConnector sc = ServerConnector.getInstance();
        JSONObject post_json = new JSONObject();
        try {
            post_json.put("password", password);
            post_json.put("email", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            Type type = new TypeToken<ArrayList<UsersEntity>>() {
            }.getType();
            List<NameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("email", email));
            list.add(new BasicNameValuePair("password", password));
            JSONObject json = sc.postJSontoUrl2(login_url, list,post_json.toString());
            if (json != null) {
                if (json.getBoolean("state")) {
                    ArrayList<UsersEntity> list_users = gson.fromJson(json.getJSONArray("rows").toString(), type);
                    return list_users.get(0);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UsersEntity registerUser(UsersEntity newUser) {
        ServerConnector sc = ServerConnector.getInstance();
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("firstname", newUser.getFirstname()));
        list.add(new BasicNameValuePair("lastname", newUser.getLastname()));
        list.add(new BasicNameValuePair("email", newUser.getEmail()));
        list.add(new BasicNameValuePair("password", newUser.getPassword()));
        list.add(new BasicNameValuePair("con_password", newUser.getPassword()));
        list.add(new BasicNameValuePair("phone", newUser.getPhone()));
        list.add(new BasicNameValuePair("website", newUser.getWebsite()));
        list.add(new BasicNameValuePair("company", newUser.getCompany()));
        list.add(new BasicNameValuePair("country", newUser.getCountry()));
        list.add(new BasicNameValuePair("city", newUser.getCity()));
        list.add(new BasicNameValuePair("zip_code", newUser.getZip_code()));
        JSONObject json = sc.postJSontoUrl2(register_url, list, "");
        return null;
    }
}
