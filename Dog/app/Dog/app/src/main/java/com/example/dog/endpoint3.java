package com.example.dog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface endpoint3 {
    @GET("/breed/hound/images")
    Call<Model3> getImge();
}
