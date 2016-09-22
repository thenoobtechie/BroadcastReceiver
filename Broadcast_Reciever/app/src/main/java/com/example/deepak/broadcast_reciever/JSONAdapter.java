package com.example.deepak.broadcast_reciever;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JSONAdapter extends BaseAdapter implements ListAdapter {

    private final Activity activity;
    public JSONArray jsonArray;

    protected JSONAdapter(Activity activity, JSONArray jsonArray) {
        assert activity != null;
        assert jsonArray != null;

        this.jsonArray = jsonArray;
        this.activity = activity;
    }
    @Override public int getCount() {
        if(jsonArray==null)
            return 0;
        else
            return jsonArray.length();
    }

    @Override public JSONObject getItem(int position) {
        if(jsonArray==null) return null;
        else
            return jsonArray.optJSONObject(position);
    }

    @Override public long getItemId(int position) {
        JSONObject jsonObject = getItem(position);

        return jsonObject.optLong("id");
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = activity.getLayoutInflater().inflate(R.layout.row, null);

        TextView text1 = (TextView) convertView.findViewById(R.id.tv1);
        TextView text2 = (TextView) convertView.findViewById(R.id.tv2);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv1);

            JSONObject jo = null;
            try {
                jo = jsonArray.getJSONObject(position);
                text1.setText(jo.getString("name"));
                text2.setText(jo.getString("designations"));
                if(jo.getBoolean("admin")){
                    imageView.setImageResource(R.drawable.c);
                }
                else
                    imageView.setImageResource(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return convertView;
    }
}


