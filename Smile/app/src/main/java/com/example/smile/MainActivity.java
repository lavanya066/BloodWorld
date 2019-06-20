package com.example.smile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements callback {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        txt=findViewById(R.id.txt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomsheetclass sheet=new bottomsheetclass(MainActivity.this);
                sheet.show(getSupportFragmentManager(),"showing");
            }
        });
    }

    @Override
    public void success(CharSequence s) {
       txt.setText(s);
    }
}
