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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("ValidFragment")
public class Imagefrag extends Fragment {
    private static final String TAG = "ERROR";
    String message;
   // TextView t;
    Button bt;
    ImageView img;
    fragclallback2 fragCallback;
    Context context;
    //Model2 model2=new Model2();
    @SuppressLint("ValidFragment")
    public Imagefrag(fragclallback2 frm,Context context) {
        this.fragCallback = frm;
        this.context=context;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.imglayout, container, false);

        super.onCreate(savedInstanceState);

//t=view.findViewById(R.id.t);
        bt=view.findViewById(R.id.btn_fragment_img);
      img=view.findViewById(R.id.image101);

        // resultAdapters.notifyDataSetChanged();
bt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        endpoint2 service = Api.getRetrofitInstance().create(endpoint2.class);
        Call<Model2> call = service.getImg();
        call.enqueue(new Callback<Model2>() {
            @Override
            public void onResponse(Call<Model2> call, Response<Model2> response) {

                Picasso.with(getContext()).load(response.body().getMessage()).into(img);
//                message = response.body().getMessage();
                Log.d("SUCC",message+"DAATA");
                //Log.d("SUCC",message+"DAATA");


            }



            @Override
            public void onFailure(Call<Model2> call, Throwable t) {
                Log.d("FAIL",t.toString()+"DAATA");
            }
        });



    }
});








        fragCallback.allsuccess();
        return view;

    }
}