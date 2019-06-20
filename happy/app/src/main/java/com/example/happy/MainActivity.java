package com.example.happy;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BottomSheetBehavior bottomSheetBehavior;
    TextView txt;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        txt=findViewById(R.id.txt);
        edit=findViewById(R.id.edit);
       // txt2=findViewById(R.id.txt2);
        Button bt=findViewById(R.id.b2);
        View bottom=findViewById(R.id.bottomsheet);
        bottomSheetBehavior=BottomSheetBehavior.from(bottom);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch (i)
                {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //txt2.setText("Collapsed");
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                       //txt2.setText("EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                      // txt2.setText("DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                       //txt2.setText("HIDDEN");
                        break;


                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(edit.getText());

            }
        });
    }

}
