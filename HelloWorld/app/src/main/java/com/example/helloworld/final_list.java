package com.example.helloworld;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.helloworld.MovieAdapters.*;

public class final_list extends AppCompatActivity {
   // private List<Movies> moviesList=new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapters movieAdapters;
    private List<Datum> movieList = new ArrayList<>();

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //movieAdapters = new MovieAdapters(movieList);

        ApiInterface apiService =
                Api.getClient().create(ApiInterface.class);
        Call<ModelServer> call = apiService.getitem();
        call.enqueue(new Callback<ModelServer>() {
            @Override
            public void onResponse(Call<ModelServer> call, Response<ModelServer> response) {
                movieList=response.body().getData();
                movieAdapters=new MovieAdapters(movieList,getApplicationContext());
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(movieAdapters);

            }

            @Override
            public void onFailure(Call<ModelServer> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


    }
}
