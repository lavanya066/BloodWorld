package com.example.firebase;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Application {
    public static final String channel="channel1";


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            NotificationChannel channel1=new NotificationChannel(channel,"channel 1", NotificationManager.IMPORTANCE_DEFAULT);
      channel1.setDescription("channel1");
    }
}
}