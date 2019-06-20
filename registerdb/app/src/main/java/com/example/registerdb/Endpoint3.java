package com.example.registerdb;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Endpoint3 {
    @FormUrlEncoded
    @PUT("putting")
    Call<overall> getitem(@Field("username")String username,
                          @Field("password")String password,
                          @Field("age")String age,
                          @Field("gender")String gender,
                          @Field("email")String email,
                          @Field("address")String address
    );
}
