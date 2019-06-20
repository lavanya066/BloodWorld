package com.example.showoff;

import retrofit2.Call;
import retrofit2.http.GET;

public interface endpoint {
    @GET("api/users")
     Call<ModelClass> getitems();
}
