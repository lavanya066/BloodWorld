package com.example.dog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class Imagelistfrag extends Fragment {
    private static final String TAG = "ERROR";
    List<String> message;
    // TextView t;
    Button bt;
    ImageView img;
    fragclaaback3 fragCallback;
    Context context;
    //Model2 model2=new Model2();
    @SuppressLint("ValidFragment")
    public Imagelistfrag(fragclaaback3 frm,Context context) {
        this.fragCallback = frm;
        this.context=context;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.imagelist, container, false);

        super.onCreate(savedInstanceState);

//t=view.findViewById(R.id.t);
        bt=view.findViewById(R.id.btn);
        img=view.findViewById(R.id.imgfraglist);

        // resultAdapters.notifyDataSetChanged();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                endpoint3 service = Api.getRetrofitInstance().create(endpoint3.class);
                Call<Model3> call=service.getImge();
                call.enqueue(new Callback<Model3>() {
                    @Override
                    public void onResponse(Call<Model3> call, Response<Model3> response) {
                        int l=response.body().getMessage().size();
                        int i;
                        for(i=0;i<l;i++) {
                            Picasso.with(getContext()).load(response.body().getMessage().toString()).into(img);
                        }


//                message = response.body().getMessage();
                        Log.d("SUCC",message+"DAATA");
                        //Log.d("SUCC",message+"DAATA");


                    }



                    @Override
                    public void onFailure(Call<Model3> call, Throwable t) {
                        Log.d("FAIL",t.toString()+"DAATA");
                    }
                });



            }
        });








        fragCallback.successful();
        return view;

    }
}