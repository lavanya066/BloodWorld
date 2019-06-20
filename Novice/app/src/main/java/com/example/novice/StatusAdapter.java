package com.example.novice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {
    @NonNull
    private List<Status> statusList;
    private Context context;
    ImageView img;
    CardView card;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt,place;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.id);
            place=itemView.findViewById(R.id.place);
        }
    }
    public StatusAdapter(List<Status> statusList)
    {
        this.statusList = statusList;
    }
    public StatusAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main,viewGroup,false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
     myViewHolder.txt.setText(statusList.get(i).getId().toString());
        if(statusList.get(i).getPlace()!=null){
myViewHolder.place.setText(statusList.get(i).getPlace().getBoundingBox().getCoordinates().toString());
        }

    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

}
