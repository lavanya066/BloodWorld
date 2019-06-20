package com.example.narayaneeyam;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class finale extends AppCompatActivity implements framecallback {

    private List<Dashakams> dashakamsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private adapter lAdapter;
     framecallback frag;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        lAdapter = new adapter(dashakamsList,this);
        int i;
        for (i = 1; i <= 100; i++) {
            Dashakams movie = new Dashakams("Dashakam " + i);
            dashakamsList.add(movie);
        }

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(lAdapter);



      //  String a="abc";
//txt1.setText(a.toString());

       /*
        */


    }


    @Override
    public void success(int pos) {
        dashakamsList.get(pos);
        if (pos==0) {
            Intent a = new Intent(finale.this, dashakam1.class);
            startActivity(a);
        }
    }
}
