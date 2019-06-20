/*package com.example.users;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Passing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_passing);
        //final EditText txt;
     //   txt=findViewById(R.id.txt);
        Button bt;
        bt=findViewById(R.id.bts);


        bt.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent o=new Intent(Passing.this,MainActivity.class);
                o.putExtra("Go", txt.getText().toString());
                startActivity(o);
            }
        });
    }
}*/
