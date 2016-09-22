package com.example.deepak.broadcast_reciever;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Async_con con = new Async_con(MainActivity.this);
        String url =  "https://dev.eiris.in/feeds/55b79cc2872ef87c1824f0b6/562b8dd8872ef86f750c6f97/channel/followers/570e386bd517f012f5ef25a0/";
        con.execute(url);

    }

    /*public void addNew(){
        FragmentManager fm = getFragmentManager();
        Fragment fr = fm.findFragmentById(R.id.frag2);
        FragmentTransaction ft = fm.beginTransaction();
        LinearLayout root = (LinearLayout) MainActivity.this.findViewById(R.id.root_layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        for (int i = 0; i < input.length(); i++) {
            val = input.optJSONObject(i).optString(Constants.TYPE);
            if (val.equals(Constants.TXT)) {
                if(input.optJSONObject(i).optBoolean(Constants.NUMBER))
                {
                    LinearLayout l1 = new LinearLayout(this);
                    l1.setOrientation(LinearLayout.HORIZONTAL);

                    TextView nameLbl = new TextView(this);
                    nameLbl.setText(input.optJSONObject(i).optString(Constants.LBL));
                    l1.addView(nameLbl);

                    EditText nameTxt = new EditText(this);
                    nameTxt.setId(i);
                    nameTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
                    nameTxt.setLayoutParams(params);
                    l1.addView(nameTxt);
                    root.addView(l1);
                }
                else {
                    LinearLayout l1 = new LinearLayout(this);
                    l1.setOrientation(LinearLayout.HORIZONTAL);

                    TextView nameLbl = new TextView(this);
                    nameLbl.setText(input.optJSONObject(i).optString(Constants.LBL));
                    l1.addView(nameLbl);

                    EditText nameTxt = new EditText(this);
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
                LinearLayout l1 = new LinearLayout(this);
                l1.setOrientation(LinearLayout.HORIZONTAL);

                TextView nameLbl = new TextView(this);
                nameLbl.setText(input.optJSONObject(i).optString(Constants.LBL));
                l1.addView(nameLbl);

                Spinner dd = new Spinner(this);
                l1.addView(dd);
                dd.setLayoutParams(params);

                root.addView(l1);

                strArray = input.optJSONObject(i).optJSONArray(Constants.OPTIONS);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, f1(strArray));
                dd.setAdapter(adapter);

            }
        }

    }*/


    public void broadcastIntent(View v) throws IOException{
        Intent in = new Intent(this, broadcastReciever.class);
        in.putExtra("Message", "Connected to server");
        sendBroadcast(in);
    }
}

