package com.example.novice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {

    @GET("twittersearch?key=ado")
    Call<BaseScalarModel> getValues();
}
