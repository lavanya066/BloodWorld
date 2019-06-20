package com.example.dog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface endpoint {
    @GET("breeds/list/all")
    Call<ModelClass> getValues();


}
