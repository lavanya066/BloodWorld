package com.example.quiz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("ValidFragment")
public class Q1 extends Fragment {
    Button b1,b2,b3,b4,nxt;
    Score sc;
   int i=0;

    @SuppressLint("ValidFragment")
    public Q1(Score sc)
    {
        this.sc=sc;
    }
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.q1,container,false);
        b1=view.findViewById(R.id.b1);
        b2=view.findViewById(R.id.b2);
        b3=view.findViewById(R.id.b3);
        b4=view.findViewById(R.id.b4);
       nxt=view.findViewById(R.id.next);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.getText().toString()=="DISPUR")
                {

                 i+=1;
                    sc.score(i);
                }
                else
                {
                    sc.score(i);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2.getText().toString())
                {

                    i+=1;
                    sc.score(i);
                }
                else
                {
                    sc.score(i);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b3.getText().toString()=="DISPUR")
                {

                    i+=1;
                    sc.score(i);
                }
                else
                {
                    sc.score(i);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b4.getText().toString()=="DISPUR")
                {

                    i+=1;
                    sc.score(i);
                }
                else
                {
                    sc.score(i);
                }
            }
        });
        return view;

    }
}
