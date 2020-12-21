package com.example.tiki.chat;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiki.R;

public class MyHolder extends RecyclerView.ViewHolder{

    ImageView img_anhmau;
    TextView tv_tsp, tv_ts;
    Button bt_chat;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.img_anhmau = itemView.findViewById(R.id.img_anhmau);
        this.tv_tsp = itemView.findViewById(R.id.tv_tsp);
        this.tv_ts = itemView.findViewById(R.id.tv_ts);
        this.bt_chat = itemView.findViewById(R.id.bt_chat);
    }
}
