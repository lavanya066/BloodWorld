package com.example.showoff;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class client {
    public static final String BASE_URL = "https://reqres.in/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
