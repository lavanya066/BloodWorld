package com.example.registerdb;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.registerdb.Endpoint;
import com.example.registerdb.overall;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText usr,pwd,eml,age,add;
    private String u,p,e,a,ad,g;
    Spinner gd;
    Button b;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.b);
        gd=findViewById(R.id.gender);
        usr=findViewById(R.id.username);
        pwd=findViewById(R.id.password);
        eml=findViewById(R.id.email);
        age=findViewById(R.id.age);
        add=findViewById(R.id.address);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u= usr.getText().toString();
                p=pwd.getText().toString();
                e=eml.getText().toString();
                a= age.getText().toString();
                ad=add.getText().toString();
                g=gd.getSelectedItem().toString();

                Endpoint4 apiService =
                        Api.getClient().create(Endpoint4.class);
                Call <overall> call = apiService.getitem(u,p,a,g,e,ad);
                call.enqueue(new Callback<overall>() {
                    @Override
                    public void onResponse(Call<overall> call, Response<overall> response) {
                        String a=response.body().getMessage().toString();
                        if (a!=null){

                            Toast.makeText(MainActivity.this, a, Toast.LENGTH_SHORT).show();

                        }

                    }
                    @Override
                    public void onFailure(Call<overall> call, Throwable t) {
                        Log.d("ERRORS",t.toString());
                        Toast.makeText(MainActivity.this, "Network Issue", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });





    }


}
