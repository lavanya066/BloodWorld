package com.example.showoff;

import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.List;

import static com.example.showoff.R.layout.*;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {
    @NonNull
    public TextView song,artist;
    public List<Datum> songsList;
    private MyViewHolder myViewHolder;
    private int i;

    public class MyViewHolder extends RecyclerView.ViewHolder {
       public TextView artist,song;




       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           song=(TextView)itemView.findViewById(R.id.song);
           artist=(TextView)itemView.findViewById(R.id.artist);
       }
   }
    public SongAdapter(List<Datum> songsList) {
        this.songsList =songsList ;
    }
    public SongAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(activity_songs,viewGroup,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Datum song1=songsList.get(i);
       myViewHolder.song.setText(song1.getId());
       myViewHolder.artist.setText(song1.getAvatar());

    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }
}
