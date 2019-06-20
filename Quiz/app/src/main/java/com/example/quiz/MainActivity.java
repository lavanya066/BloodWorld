package com.example.quiz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Score {
    private Fragment fragment;
    private FragmentManager fragmentManager;
    TextView scores;
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(fragment instanceof Q1)){
                    fragment = new Q1(MainActivity.this);
                    fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();
                }
            }
        });
    }

    @Override
    public void score(int sco) {
  scores.setText(sco);
    }
}
