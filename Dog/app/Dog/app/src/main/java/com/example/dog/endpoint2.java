package com.example.dog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface endpoint2 {
    @GET("breeds/image/random")
    Call<Model2> getImg();
}
