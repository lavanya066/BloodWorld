package com.example.novice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Api {
    public static final String BASE_URL = "https://aravindtwitter.herokuapp.com/";
    private static Retrofit retrofit=null;
    //private static final String BASE_URL = SessionManager.getInstance(App.getContext()).getKeyIpAddress();
    //  private static final String BASE_URL = "http://192.168.43.193:5000";

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).addConverterFactory(ScalarsConverterFactory.create()).build();
        }
        return retrofit;
    }
}
