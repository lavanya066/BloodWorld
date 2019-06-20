package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.database.DatabaseHelper;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView txt;
    String username = "abc";
    String password="cd";
    EditText usr,psd;
    String getpsd,getusd;
    DatabaseHelper mydb=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.buttonSignIn);
        usr=findViewById(R.id.usernameet);
        psd=findViewById(R.id.passwordet);
        txt=findViewById(R.id.up);

        psd.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    function();
                    return true;
                }
                return false;
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function();


            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(l);
            }
        });

    }

    public void function(){
        getpsd = psd.getText().toString();
        getusd = usr.getText().toString();

        if(mydb.checkUser(getusd,getpsd)==1)
        {
            Intent ui = new Intent(MainActivity.this,WelcomeActivity.class);
            startActivity(ui);
        }

        else
        {
            Toast.makeText(MainActivity.this, "user name or password in incorrect", Toast.LENGTH_SHORT).show();
        }


    }

}
