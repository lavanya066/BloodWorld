package com.example.users;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ResultAdapters extends RecyclerView.Adapter<ResultAdapters.MyViewHolder> {
    @NonNull
    private List<Result> resultList;
    private Context context;
    ImageView img;
    CardView card;
    int l;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView id1;
        public TextView overview;



        public MyViewHolder(View itemView)
       {
           super(itemView);
           title=(TextView)itemView.findViewById(R.id.titl);
           overview=itemView.findViewById(R.id.overview);
           img= (ImageView)itemView.findViewById(R.id.image_view);
           card = (CardView)itemView.findViewById(R.id.card);
           id1=itemView.findViewById(R.id.id1);
       }
    }
    public ResultAdapters(List<Result> resultList, Context context) {
        this.resultList = resultList;
        this.context = context;
    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main,viewGroup,false);
        return new MyViewHolder(itemView);
    }



    public void onBindViewHolder( MyViewHolder myViewHolder,final int i) {
        myViewHolder.title.setText(resultList.get(i).getTitle());
        myViewHolder.overview.setText(resultList.get(i).getOverview());


        Picasso.with(context).load("https://image.tmdb.org/t/p/w500"+resultList.get(i).getPosterPath()).into(img);

        for (l=0;l<resultList.get(i).getGenreIds().size();l++)
       {
            myViewHolder.id1.setText(myViewHolder.id1.getText().toString()+"\n"+resultList.get(i).getGenreIds().get(l).toString());
        }
        //Log.i("data",resultList.get(i).getPosterPath());

        card.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent a =new Intent(context,getAll.class);
             a.putExtra("title", resultList.get(i).getTitle());
             a.putExtra("overview", resultList.get(i).getOverview());
             a.putExtra("image","https://image.tmdb.org/t/p/w500"+resultList.get(i).getPosterPath() );
             context.startActivity(a);
         }
     });

    }


    @Override
    public int getItemCount() {
        return resultList.size();
    }
}