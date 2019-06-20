package com.example.blooddonationapp.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.blooddonationapp.R;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        EasySplashScreen config=new EasySplashScreen(SplashScreen.this).withFullScreen().withTargetActivity(LoginPage.class).withSplashTimeOut(4000).withLogo(R.drawable.screensplash).withBeforeLogoText("DONATE BLOOD SAVE LIFE");
        View easySplashScreen=config.create();
        setContentView(easySplashScreen);
    }
}
