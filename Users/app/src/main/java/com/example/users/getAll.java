package com.example.users;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class getAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);
        String title = getIntent().getStringExtra("title");
        String overview = getIntent().getStringExtra("overview");
        String image = getIntent().getStringExtra("image");
        TextView txt,over;
       ImageView img;
        txt=findViewById(R.id.txt101);
        over=findViewById(R.id.over101);
       img=findViewById(R.id.image101);
       txt.setText(title);
        over.setText(overview);
        Picasso.with(this).load(image).into(img);
    }
}
