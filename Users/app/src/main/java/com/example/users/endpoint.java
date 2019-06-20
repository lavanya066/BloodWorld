package com.example.users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface endpoint {

        @GET("search/movie?language=en-US&page=1")
        Call<ModelClass> getValues(
                @Query("api_key") String key,
                @Query("query") String query,
                @Query("include_adult") String include
        );


//    @GET("search/{id}")
 //   Call<ModelClass> getMovieDetails(@Path("id") int id ,@Query("api_key") String apiKey);
    }

