package com.example.dog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {
    private Message message;
    private Context context;
    public MessageAdapter(){}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt,txt1,txt2,txt3,txt4;
        public TextView txt5,txt6,txt7,txt8,txt9,txt10;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt);
            txt1=itemView.findViewById(R.id.txt1);
            txt2=itemView.findViewById(R.id.txt2);
            txt3=itemView.findViewById(R.id.txt3);
            txt4=itemView.findViewById(R.id.txt4);
            txt5=itemView.findViewById(R.id.txt5);
            txt6=itemView.findViewById(R.id.txt6);
            txt7=itemView.findViewById(R.id.txt7);
            txt8=itemView.findViewById(R.id.txt8);
            txt9=itemView.findViewById(R.id.txt9);
            txt10=itemView.findViewById(R.id.txt10);
        }
    }
    public MessageAdapter(Message message) {
        this.message = message;

    }
    @NonNull
    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MyViewHolder myViewHolder, int i) {
        int l;
        for (l=0;l<message.getBulldog().size();l++)
        {
            myViewHolder.txt.setText(myViewHolder.txt.getText().toString()+"\n"+message.getBulldog().get(l).toString());
        }
        for (l=0;l<message.getBullterrier().size();l++)
        {
            myViewHolder.txt1.setText(myViewHolder.txt1.getText().toString()+"\n"+message.getBullterrier().get(l).toString());
        }
        for (l=0;l<message.getCattledog().size();l++)
        {
            myViewHolder.txt2.setText(myViewHolder.txt2.getText().toString()+"\n"+message.getCattledog().get(l).toString());
        }
        for (l=0;l<message.getCollie().size();l++)
        {
            myViewHolder.txt3.setText(myViewHolder.txt3.getText().toString()+"\n"+message.getCollie().get(l).toString());
        }
        for (l=0;l<message.getCorgi().size();l++)
        {
            myViewHolder.txt4.setText(myViewHolder.txt4.getText().toString()+"\n"+message.getCorgi().get(l).toString());
        }
        for (l=0;l<message.getDane().size();l++)
        {
            myViewHolder.txt5.setText(myViewHolder.txt5.getText().toString()+"\n"+message.getDane().get(l).toString());
        }
        for (l=0;l<message.getDeerhound().size();l++)
        {
            myViewHolder.txt6.setText(myViewHolder.txt6.getText().toString()+"\n"+message.getDeerhound().get(l).toString());
        }
        for (l=0;l<message.getElkhound().size();l++)
        {
            myViewHolder.txt7.setText(myViewHolder.txt7.getText().toString()+"\n"+message.getElkhound().get(l).toString());
        }
        for (l=0;l<message.getFrise().size();l++)
        {
            myViewHolder.txt8.setText(myViewHolder.txt8.getText().toString()+"\n"+message.getFrise().get(l).toString());
        }
        for (l=0;l<message.getGreyhound().size();l++)
        {
            myViewHolder.txt9.setText(myViewHolder.txt9.getText().toString()+"\n"+message.getGreyhound().get(l).toString());
        }
        for (l=0;l<message.getHound().size();l++)
        {
            myViewHolder.txt10.setText(myViewHolder.txt10.getText().toString()+"\n"+message.getHound().get(l).toString());
        }


    }

    @Override
    public int getItemCount() {
        return 1 ;
    }


}
