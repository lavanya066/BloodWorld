/*package com.example.narayaneeyam;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class getAll extends AppCompatActivity implements framecallback {
    private Fragment fragment;
    private FragmentManager fragmentManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);
        fragmentManager = getSupportFragmentManager();
        TextView txt;
        txt=findViewById(R.id.dashakams);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(fragment instanceof dashakam1)){
                    fragment = new dashakam1((framecallback) context);
                    fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();
                }
            }
        });
    }


    @Override
    public void success() {

    }
}*/
