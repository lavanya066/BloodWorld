package com.example.novice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class Galleryclass extends Fragment {
    fragmentcallback frag;

    @SuppressLint("ValidFragment")
    public Galleryclass(fragmentcallback frm)
    {
        this.frag=frm;
    }



    @NonNull
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.gallery,container,false);



/*
        b2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                text2.setText("");

            }
        });
        text2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                frameCallback.success(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });
*/
        frag.success();
        return view;

    }
}
