package com.example.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    List<Datum> data=new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapters movieAdapters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);

        //final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ApiInterface apiService =
                Api.getClient().create(ApiInterface.class);
        Call<ModelServer> call = apiService.getitem();


        call.enqueue(new Callback<ModelServer>() {
            @Override
            public void onResponse(Call<ModelServer> call, Response<ModelServer> response) {

                data=response.body().getData();
                setAdapterRecyclerItem(data);

                //Log.d(TAG, "Number : " + tot);
            }

            @Override
            public void onFailure(Call<ModelServer> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void setAdapterRecyclerItem(List<Datum> data) {
        movieAdapters = new MovieAdapters(data,getApplicationContext());
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(movieAdapters);
    }
}
