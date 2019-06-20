package com.example.registerdb;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Endpoint {
    @FormUrlEncoded
    @POST("user")
    Call<overall> getitem(@Field("username")String username,
                          @Field("password")String password,
                          @Field("age")String age,
                          @Field("gender")String gender,
                          @Field("email")String email,
                          @Field("address")String address);
}


