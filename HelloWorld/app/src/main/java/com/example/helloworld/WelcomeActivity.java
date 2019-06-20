package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class WelcomeActivity extends AppCompatActivity {
    TextView txt;
    TextView txt1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        txt=findViewById(R.id.welc);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(a);
            }
        });
        txt1=findViewById(R.id.click);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent b=new Intent(WelcomeActivity.this,final_list.class);
                 startActivity(b);


            }
        });
    }
}
