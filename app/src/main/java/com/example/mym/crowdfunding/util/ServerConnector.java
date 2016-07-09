package com.example.mym.crowdfunding.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mert on 5/30/2016.
 */

public class ServerConnector {
    private static ServerConnector ourInstance = new ServerConnector();
   // private static final String server_ip = "http://10.18.3.177";
    private static final String server_ip = "http://www.airshowroom.com";
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

    public static JSONObject postJSONtoUrl(String targetURL, String json) {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            targetURL = server_url + targetURL;
            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/json");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(json.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream ());
            wr.writeBytes (json);
            wr.flush ();
            wr.close ();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return new JSONObject(response.toString());

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    public static JSONObject postJSontoUrl2(String targetURL, List<NameValuePair> params, String json) {
        HttpClient httpClient = new DefaultHttpClient(); //Deprecated
        targetURL = server_url + targetURL;
        try {
            HttpPost request = new HttpPost(targetURL);
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(new StringEntity(getStringVersion(params)));
            HttpResponse response = httpClient.execute(request);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            Log.d("http resos",result.toString());
            return new JSONObject(result.toString());
        }catch (Exception ex) {
            // handle exception here
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

    private static String getStringVersion(List<NameValuePair> list) {
        int size = list.size();
        String s ="";
        int i =0;
        for (; i<size-1; i++) {
            s += list.get(i).getName() + "=" + list.get(i).getValue() + "&";
        }
        s += list.get(i).getName() + "=" + list.get(i).getValue();
        return s;
    }

}
