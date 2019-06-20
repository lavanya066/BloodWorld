package com.example.registerdb;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Endpoint2 {
    @FormUrlEncoded
    @POST("check")
    Call<overall> getitem(@Field("username")String username,
                          @Field("password")String password
                          );
}
