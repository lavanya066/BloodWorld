package com.example.users;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Main2Axtivity extends AppCompatActivity implements framecallback {
    private Fragment fragment;
    private FragmentManager fragmentManager;
    Button blue,yellow,b1,b2;
    TextView tt;
    TextView tt1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_2_activity);
        fragmentManager = getSupportFragmentManager();
        blue=(Button)findViewById(R.id.blue);
        yellow=(Button)findViewById(R.id.yellow);
         tt=findViewById(R.id.tt);
tt1=findViewById(R.id.tt1);



//         blue.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 if(!(fragment instanceof fragelement)){
//                     fragment = new fragelement(Main2Axtivity.this);
//                     fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();
//                 }
//             }
//         });
        blue.setOnClickListener(v -> {
            if(!(fragment instanceof fragelement)){
                fragment = new fragelement(this);
                fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();
            }
        });




        yellow.setOnClickListener(v -> {
            if(!(fragment instanceof fraglayout)){
                fragment = new fraglayout(this);
                fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();
            }
        });
    }

   /* public void test(){
        if(!(fragment instanceof fragelement)){
            fragment = new fragelement(this);
            fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();
        }
    }*/





    @Override
    public void success(CharSequence s,CharSequence m) {
        tt.setText(s);
        tt1.setText(m);
    }
}
