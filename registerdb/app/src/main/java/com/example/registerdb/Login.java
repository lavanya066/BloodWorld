package com.example.registerdb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText user,pass;
    Button bon;
    String u,p;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user=findViewById(R.id.userlogin);
        pass=findViewById(R.id.passwordlogin);
        bon=findViewById(R.id.buttonlogin);
        bon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            u=user.getText().toString();
            p=pass.getText().toString();
                Endpoint2 apiService =
                        Api.getClient().create(Endpoint2.class);
                Call <overall> call=apiService.getitem(u,p);
                call.enqueue(new Callback<overall>() {
                    @Override
                    public void onResponse(Call<overall> call, Response<overall> response) {
                        String a=response.body().getMessage().toString();
                        if (a!=null){

                            Toast.makeText(Login.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();

                        }

                    }
                    @Override
                    public void onFailure(Call<overall> call, Throwable t) {
                        Log.d("ERRORS",t.toString());
                        Toast.makeText(Login.this, "Network Issue", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
}
