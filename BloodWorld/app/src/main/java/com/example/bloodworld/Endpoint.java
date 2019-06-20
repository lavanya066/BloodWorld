package com.example.bloodworld;



import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface Endpoint {
    @POST("register")
    Call<User> createdb(@Body JsonObject user);
    @GET("register")
    Call<Check> checkdb(@Body JsonObject check);
}
