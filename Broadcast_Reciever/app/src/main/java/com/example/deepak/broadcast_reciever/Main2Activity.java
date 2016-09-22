package com.example.deepak.broadcast_reciever;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {
    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       /* Async_con con = new Async_con(Main2Activity.this);
        String url =  "https://dev.eiris.in/feeds/55b79cc2872ef87c1824f0b6/562b8dd8872ef86f750c6f97/channel/followers/570e386bd517f012f5ef25a0/";
        con.execute(url);*/

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frag1, new BlankFragment());
        ft.commit();
    }

    public void addNew() {
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.frag2, new BlankFragment2());
        ft.commit();

    }
}
