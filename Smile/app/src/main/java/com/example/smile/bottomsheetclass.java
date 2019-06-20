package com.example.smile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("ValidFragment")
public class bottomsheetclass extends BottomSheetDialogFragment {
    callback call;
    @SuppressLint("ValidFragment")
    public bottomsheetclass(callback call)
    {
     this.call=call;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bottomsheet,container,false);
        Button b1=view.findViewById(R.id.b1);
        final EditText edit=view.findViewById(R.id.edit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
call.success(edit.getText().toString());
dismiss();
            }
        });
        return view;
    }
}
