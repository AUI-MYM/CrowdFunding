package com.example.mym.crowdfunding.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by Mert on 5/30/2016.
 */

public class ServerConnector {
    private static ServerConnector ourInstance = new ServerConnector();
    private static final String server_ip = "http://10.18.3.177";
    //private static final String server_ip = "http://www.airshowroom.com";
    public static final String server_url = server_ip + "/cf/index.php/";
    public static final String server_image_url = server_ip + "/cf/pic/";
    public static final String server_avatar_url = server_ip + "/cf/avatar/";

    public static ServerConnector getInstance() {
        return ourInstance;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject getJSONFromUrl(String url) {
        InputStream is = null;
        try {
            is = new URL(server_url + url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public ArrayList<Bitmap> getImagesFromURLList(String[] urls) {
        ArrayList<Bitmap> list = new ArrayList<>();
        for (String url_string : urls) {
            URL url;
            try {
                url = new URL(url_string);
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection()
                        .getInputStream());
                list.add(bmp);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private ServerConnector() {

    }

}
