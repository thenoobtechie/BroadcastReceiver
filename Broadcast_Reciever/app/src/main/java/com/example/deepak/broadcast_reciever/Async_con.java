package com.example.deepak.broadcast_reciever;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Async_con extends AsyncTask<String,String,String> {

    Activity mActivity;
    String data;
    JSONAdapter jsonAdapter;

    public Async_con(Activity activity) {
        mActivity = activity;
    }
    @Override
    protected String doInBackground(String... objects) {

        InputStream is = null;
        try {
            URL url = new URL(objects[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(10000);
            con.setReadTimeout(15000);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setRequestProperty("Connection", "Keep-Alive");
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestMethod("GET");
            con.connect();
            con.getResponseCode();
            is = con.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(is),8);
            StringBuilder sBuilder = new StringBuilder();
            String line ;
            while ((line = bReader.readLine()) != null) {
                sBuilder.append(line + "\n");
            }
            data = sBuilder.toString();
        }
        catch (Exception e){
            Log.d("Error",e.toString());
        }
        finally {
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    protected void onPostExecute(String name){
        ListView listView = (ListView)mActivity.findViewById(R.id.lst);
        JSONObject jsonObject;
        JSONArray jsonArray = null;
        try {
            jsonObject = new JSONObject(data);
            String temp = jsonObject.optString("result");
            jsonArray = new JSONArray(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ProgressBar pb = (ProgressBar)mActivity.findViewById(R.id.pb);
        pb.setVisibility(View.INVISIBLE);
        jsonAdapter = new JSONAdapter(mActivity, jsonArray);
        listView.setAdapter(jsonAdapter);
    }
}
