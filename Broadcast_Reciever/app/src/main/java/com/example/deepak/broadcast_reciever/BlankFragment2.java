package com.example.deepak.broadcast_reciever;


import android.os.Bundle;
import android.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import java.util.ArrayList;

public class BlankFragment2 extends Fragment {

    public static final String strJson = "[{" +
            " \"type\": \"txt\", \"lbl\": \"Name\", \"required\": true }, {" +
            " \"type\": \"txt\", \"lbl\": \"Age\", \"number\": true, \"min\": 18," +
            " \"max\": 60," +
            " \"required\": true }, {" +
            " \"type\": \"dd\", \"lbl\": \"Gender\", \"options\": [\"male\", \"female\", \"other\"] }," +
            " {\"type\": \"txt\", \"lbl\": \"Address\", \"multiLine\": true }, " +
            " {\"type\": \"txt\", \"lbl\": \"Review\", \"multiLine\": true },{" +
            " \"type\": \"dd\", \"lbl\": \"Hobbies\", \"options\": [\"Cricket\", \"Singing\", \"Swimming\"] }]";

    JSONArray input;
    {
        try {
            input = new JSONArray(strJson);
        } catch (JSONException e1) {
            input = new JSONArray();
            e1.printStackTrace();
        }
    }

    JSONArray strArray;


    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String val;
        // Inflate the layout for this fragment
        LinearLayout root = (LinearLayout)container.findViewById(R.id.root_layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        for (int i = 0; i < input.length(); i++) {
            val = input.optJSONObject(i).optString(Constants.TYPE);
            if (val.equals(Constants.TXT)) {
                if(input.optJSONObject(i).optBoolean(Constants.NUMBER))
                {
                    LinearLayout l1 = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        l1 = new LinearLayout(getContext());
                    }
                    l1.setOrientation(LinearLayout.HORIZONTAL);

                    TextView nameLbl = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        nameLbl = new TextView(getContext());
                    }
                    nameLbl.setText(input.optJSONObject(i).optString(Constants.LBL));
                    l1.addView(nameLbl);

                    EditText nameTxt = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        nameTxt = new EditText(getContext());
                    }
                    nameTxt.setId(i);
                    nameTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
                    nameTxt.setLayoutParams(params);
                    l1.addView(nameTxt);
                    root.addView(l1);
                }
                else {
                    LinearLayout l1 = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        l1 = new LinearLayout(getContext());
                    }
                    l1.setOrientation(LinearLayout.HORIZONTAL);

                    TextView nameLbl = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        nameLbl = new TextView(getContext());
                    }
                    nameLbl.setText(input.optJSONObject(i).optString(Constants.LBL));
                    l1.addView(nameLbl);

                    EditText nameTxt = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        nameTxt = new EditText(getContext());
                    }
                    nameTxt.setLayoutParams(params);
                    if (input.optJSONObject(i).optBoolean(Constants.MULTILINE)) {
                        nameTxt.setSingleLine(false);
                        nameTxt.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                        nameTxt.setLines(5);
                        nameTxt.setVerticalScrollBarEnabled(true);
                    }
                    nameTxt.setId(i);
                    l1.addView(nameTxt);
                    root.addView(l1);
                }
            } else if (val.equals("dd")) {
                LinearLayout l1 = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    l1 = new LinearLayout(getContext());
                }
                l1.setOrientation(LinearLayout.HORIZONTAL);

                TextView nameLbl = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    nameLbl = new TextView(getContext());
                }
                nameLbl.setText(input.optJSONObject(i).optString(Constants.LBL));
                l1.addView(nameLbl);

                Spinner dd = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    dd = new Spinner(getContext());
                }
                l1.addView(dd);
                dd.setLayoutParams(params);

                root.addView(l1);

                strArray = input.optJSONObject(i).optJSONArray(Constants.OPTIONS);

                ArrayAdapter<String> adapter = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, f1(strArray));
                }
                dd.setAdapter(adapter);


            }
        }

        return inflater.inflate(R.layout.fragment_blank_fragment2, container, false);

    }
    public ArrayList<String> f1(JSONArray jsonArray) {
        ArrayList<String> stringArray = new ArrayList<String>();
        for (int i = 0, count = jsonArray.length(); i < count; i++) {
            stringArray.add(jsonArray.optString(i));
        }
        return stringArray;
    }

}
