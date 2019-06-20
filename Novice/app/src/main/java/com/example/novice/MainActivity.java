package com.example.novice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ERROR";
    List<Status> statusList=new ArrayList<>();
    private RecyclerView recyclerView;
    private StatusAdapter statusAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finale);
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);


        Endpoint service=Api.getRetrofitInstance().create(Endpoint.class);
        Call<BaseScalarModel> call=service.getValues();
        call.enqueue(new Callback<BaseScalarModel>() {
            @Override
            public void onResponse(Call<BaseScalarModel> call, Response<BaseScalarModel> response) {
                statusList=response.body().getStatuses();
                data(statusList);
            }

            @Override
            public void onFailure(Call<BaseScalarModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"lllll",Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.toString());
            }
        });






    }
    private void data(final List<Status> statusList)
    {
        statusAdapter = new StatusAdapter(statusList);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(statusAdapter);

    }
}
