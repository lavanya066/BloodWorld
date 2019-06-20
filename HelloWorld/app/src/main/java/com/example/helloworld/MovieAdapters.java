package com.example.helloworld;

import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapters extends RecyclerView.Adapter<MovieAdapters.MyViewHolder> {
private List<Datum> moviesList;
private String email;
private Context context;
ImageView imageView;



public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title,year;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titl);
            year=itemView.findViewById(R.id.year);
            imageView=itemView.findViewById(R.id.image_view);

        }
    }
    public MovieAdapters(List<Datum> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_movies,viewGroup,false);
    return new MyViewHolder(itemView);}

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        ;
        myViewHolder.title.setText(moviesList.get(position).getEmail());
        myViewHolder.year.setText(moviesList.get(position).getFirstName());
        Picasso.with(context).load(moviesList.get(position).getAvatar()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();

    }

}
