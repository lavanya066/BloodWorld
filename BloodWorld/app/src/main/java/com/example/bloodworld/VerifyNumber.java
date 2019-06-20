package com.example.bloodworld;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.gson.JsonObject;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.VERSION_CODES.P;

public class VerifyNumber extends AppCompatActivity {
    private String verificationid;
    EditText txt;
    private FirebaseAuth mauth;
    Button otpbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_number);
        mauth=FirebaseAuth.getInstance();
        final String phonenumber=getIntent().getStringExtra("phonenumber");

        sendVerification(phonenumber);




        otpbutton=findViewById(R.id.otpbutton);
         txt=findViewById(R.id.editotp);
        otpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code=txt.getText().toString();
                if(code.isEmpty())
                {
                    txt.setError("enter otp" );
                }
                Verification(code);
            }
        });
    }
    private void Verification(String phonenumber){
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationid,phonenumber);
        signInWithCredential(credential);
    }
    private void signInWithCredential(PhoneAuthCredential credential) {
        mauth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            final String phonenumber=getIntent().getStringExtra("phonenumber");
                            final String password=getIntent().getStringExtra("password");
                            final String email=getIntent().getStringExtra("email");
                            final String age=getIntent().getStringExtra("age");
                            final String username=getIntent().getStringExtra("username");
                            final String weight=getIntent().getStringExtra("weight");
                            final String gender=getIntent().getStringExtra("gender");
                            final String lat=getIntent().getStringExtra("latitude");
                            final String lng=getIntent().getStringExtra("longitude");
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("username", username);
                            jsonObject.addProperty("password", password);
                            jsonObject.addProperty("email", email);
                            jsonObject.addProperty("age", age);
                            jsonObject.addProperty("weight", weight);
                            jsonObject.addProperty("gender", gender);
                            jsonObject.addProperty("phonenumber", phonenumber);
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
                            Intent intent = new Intent(VerifyNumber.this, ProfileActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                            startActivity(intent);

                        } else {
                            Toast.makeText(VerifyNumber.this, "not possible", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    private void sendVerification(String number){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,mCallback);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationid=s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code=phoneAuthCredential.getSmsCode();
        if(code!=null){
            txt.setText(code);
            Verification(code);
        }


        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(VerifyNumber.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    };
}
