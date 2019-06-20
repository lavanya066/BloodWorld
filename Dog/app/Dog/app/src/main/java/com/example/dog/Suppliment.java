package com.example.dog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Suppliment extends AppCompatActivity implements fragcallback,fragclallback2,fragclaaback3 {
    private Fragment fragment;
    private FragmentManager fragmentManager;
    Button blue,yellow,b1,b2;
    TextView tt;
    TextView tt1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliment);
        fragmentManager = getSupportFragmentManager();
        blue=(Button)findViewById(R.id.textbutton);
        yellow=(Button)findViewById(R.id.imgbutton);
b1=findViewById(R.id.imgfraglist);


//         blue.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 if(!(fragment instanceof fragelement)){
//                     fragment = new fragelement(Main2Axtivity.this);
//                     fragmentManager.beginTransaction().replace(R.id.frame,fragment).commit();
//                 }
//             }
//         });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(fragment instanceof MainActivity)) {
                    fragment = new MainActivity(Suppliment.this);
                    fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
                }
            }
        });




        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(fragment instanceof Imagefrag)) {
                    fragment = new Imagefrag(Suppliment.this,getApplicationContext());
                    fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(fragment instanceof Imagelistfrag)) {
                    fragment = new Imagelistfrag(Suppliment.this,getApplicationContext());
                    fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
                }

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
    public void success() {

    }

    @Override
    public void allsuccess() {

    }

    @Override
    public void successful() {

    }
}
