package com.example.narayaneeyam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.net.CookieHandler;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder>  {

    public List<Dashakams> dashakamsList;
    private framecallback frameCallback;


    //  public Fragment fragment;
   // public FragmentManager fragmentManager;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txt;
        framecallback frag;
      //  fragmentManager = getSupportFragmentManager();
        public MyViewHolder(@NonNull View itemView,framecallback frag) {

            super(itemView);
             txt=itemView.findViewById(R.id.dashakams);
          /*  txt.setOnClickListener(v -> {
                if (!(fragment instanceof d1class)) {
                    fragment = new d1class((framecallback) adapter.this);
                    fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
                }
            });*/
             itemView.setOnClickListener(this);
             this.frag=frag;
        }


        @Override
        public void onClick(View v) {
         frag.success(getAdapterPosition());
        }
    }
    public adapter(List<Dashakams> dashakamsList,framecallback frameCallback){
        this.dashakamsList=dashakamsList;
        this.frameCallback=frameCallback;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list, viewGroup, false);

         return new MyViewHolder(itemView,frameCallback);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Dashakams listing=dashakamsList.get(i);
        myViewHolder.txt.setText(listing.getno());


    }


    @Override
    public int getItemCount() {
        return dashakamsList.size();
    }


}
