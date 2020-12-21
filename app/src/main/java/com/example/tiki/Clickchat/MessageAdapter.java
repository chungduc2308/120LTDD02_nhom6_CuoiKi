package com.example.tiki.Clickchat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiki.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<com.example.tiki.Clickchat.MessageAdapter.MessageViewHolder> {

    private List<Message> mListMessage;
    public void setData(List<Message> list){
        this.mListMessage = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = mListMessage.get(position);
        if(message == null){
            return;
        }

        holder.tvmessage.setText(message.getMessage());

    }

    @Override
    public int getItemCount() {
        if(mListMessage!=null){
            return mListMessage.size();
        }

        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{

        private TextView tvmessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            tvmessage = itemView.findViewById(R.id.tv_message);
        }
    }
}
