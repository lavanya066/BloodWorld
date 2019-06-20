package com.example.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ERROR";
    List<Result> resultList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ResultAdapters resultAdapters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.finale);
        final EditText txt;
        final Button bts;
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        txt = findViewById(R.id.txt);
        bts = findViewById(R.id.bts);
        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                endpoint service = Api.getClient().create(endpoint.class);
                // resultAdapters.notifyDataSetChanged();
                Call<ModelClass> call = service.getValues("a108523819376f30e2b1039c55241f14", txt.getText().toString(), "false");

                call.enqueue(new Callback<ModelClass>() {

                    @Override

                    public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                        resultList = response.body().getResults();
                        data(resultList);

                        resultAdapters.notifyDataSetChanged();
                        resultAdapters.notifyDataSetChanged();
                        resultAdapters.notifyDataSetChanged();

                        // resultAdapters.notifyDataSetChanged();
                        //  Toast.makeText(getApplicationContext(),"dddd",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ModelClass> call, Throwable t) {
                        Log.e(TAG, t.toString());
                        // Toast.makeText(getApplicationContext(),"ffff",Toast.LENGTH_SHORT).show();
                    }


                    private void data(final List<Result> resultList) {
                        resultAdapters = new ResultAdapters(resultList, getApplicationContext());
                        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        //txt.setText(s);



                        resultAdapters.notifyDataSetChanged();

                    }


                });

                recyclerView.setAdapter(resultAdapters);

            }



            @Override
            public void afterTextChanged(Editable s) {

            }

        });






    }
}







