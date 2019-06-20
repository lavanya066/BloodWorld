package com.example.dog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class MainActivity extends Fragment {
    private static final String TAG = "ERROR";
    private RecyclerView recyclerView;
    Message message;
    private MessageAdapter messageAdapter;
    fragcallback fragCallback;
Context context;
    @SuppressLint("ValidFragment")
    public MainActivity(fragcallback frm) {
        this.fragCallback = frm;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler, container, false);

        super.onCreate(savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        endpoint service = Api.getRetrofitInstance().create(endpoint.class);
        // resultAdapters.notifyDataSetChanged();
        Call<ModelClass> call = service.getValues();
        call.enqueue(new Callback<ModelClass>() {


            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                message = response.body().getMessage();
                messageAdapter = new MessageAdapter(message);
                //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                data(message);
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                Log.e(TAG, t.toString());
            }

            private void data(final Message message) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(messageAdapter);
            }
        });
        fragCallback.success();
        return view;

    }
}
