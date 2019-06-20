package com.example.dog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class imageadapter extends RecyclerView.Adapter<imageadapter.MyViewHolder> {
    ImageView img;
    Context context;
    List<String> message;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image);
        }
    }
    @NonNull
    @Override
    public imageadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imglayout,viewGroup,false);
        return new imageadapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull imageadapter.MyViewHolder myViewHolder, int i) {
        Picasso.with(context).load(message.get(i)).into(img);
    }

    @Override
    public int getItemCount() {
        return message.size();
    }
    }



