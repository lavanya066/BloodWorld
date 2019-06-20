package com.example.bloodworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {
 EditText userreg,password,ageedit,weightedit,phoneedit,email,latitude,longitude;
 Spinner gender,country;

 Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        country=findViewById(R.id.countrycall);
        country.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,Country.countryNames));
        phoneedit=(EditText)findViewById(R.id.phoneedit);
        button=(Button)findViewById(R.id.button);
        userreg=findViewById(R.id.userreg);
        email=findViewById(R.id.emailedit);
        password=findViewById(R.id.password);
        ageedit=findViewById(R.id.ageedit);
        weightedit=findViewById(R.id.weightedit);
        gender=findViewById(R.id.gender);
        latitude=findViewById(R.id.latedit);
        longitude=findViewById(R.id.lonedit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String number=phoneedit.getText().toString().trim();
                final String username=userreg.getText().toString().trim();
                final String pass=password.getText().toString().trim();
                final String mail=email.getText().toString().trim();
                final String age=ageedit.getText().toString().trim();
                final String weight=weightedit.getText().toString().trim();
                final String gdr=gender.getSelectedItem().toString().trim();
                final String lat=latitude.getText().toString().trim();
                String lng=longitude.getText().toString().trim();

                String code=Country.countryAreaCodes[country.getSelectedItemPosition()];

                if (number.isEmpty()||number.length()<10){
                    phoneedit.setError("number required");
                    phoneedit.requestFocus();
                    return;
                }
                String phonenumber="+"+code+number;
                Intent intent=new Intent(Registration.this,VerifyNumber.class);
                intent.putExtra("phonenumber",phonenumber);
                intent.putExtra("username",username);
                intent.putExtra("password",pass);
                intent.putExtra("email",mail);
                intent.putExtra("age",age);
                intent.putExtra("weight",weight);
                intent.putExtra("gender",gdr);
                intent.putExtra("latitude",lat);
                intent.putExtra("longitude",lng);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            final String number=phoneedit.getText().toString().trim();
            final String username=userreg.getText().toString().trim();
            final String pass=password.getText().toString().trim();
            final String mail=email.getText().toString().trim();
            final String age=ageedit.getText().toString().trim();
            final String weight=weightedit.getText().toString().trim();
            final String gdr=gender.getSelectedItem().toString().trim();
            final String lat=latitude.getText().toString().trim();
            String lng=longitude.getText().toString().trim();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("username", username);
            jsonObject.addProperty("password", pass);
            jsonObject.addProperty("email", mail);
            jsonObject.addProperty("age", age);
            jsonObject.addProperty("weight", weight);
            jsonObject.addProperty("gender", gdr);
            jsonObject.addProperty("phonenumber", number);
            jsonObject.addProperty("latitude", lat);
            jsonObject.addProperty("lng", lng);
            Endpoint apiService =Api.getClient().create(Endpoint.class);
            Call<User> call=apiService.createdb(jsonObject);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
            startActivity(intent);
        }
    }
}
