package com.example.users;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("ValidFragment")
public class fragelement extends Fragment {


EditText text2;
Button b2;

    framecallback frameCallback;

    @SuppressLint("ValidFragment")
    public fragelement(framecallback frm)
    {
        this.frameCallback=frm;
    }
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_element,container,false);
        text2=view.findViewById(R.id.text2);
        b2=view.findViewById(R.id.b2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameCallback.success(text2.getText().toString(),null);
            }
        });

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

        return view;
    }
}
