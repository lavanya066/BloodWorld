package com.example.showoff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Datum> data=new ArrayList<>();
    private RecyclerView recyclerView;
    private SongAdapter movieAdapters;
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        endpoint apiService =
                client.getClient().create(endpoint.class);

        //all<ModelClass> call =

        Call<ModelClass> call = apiService.getitems();

        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                data=response.body().getData();
                SongAdapter=new SongAdapter(data);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(movieAdapters);
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {

            }
        });
        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(retrofit2.Call<ModelServer> call, Response<ModelServer> response) {


            }

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        songAdapter=new SongAdapter(data);
        RecyclerView.LayoutManager sLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(songAdapter);

    }

}
