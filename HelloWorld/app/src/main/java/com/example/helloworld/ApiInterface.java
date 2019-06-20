package com.example.helloworld;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/users")
    Call<ModelServer> getitem();
}
