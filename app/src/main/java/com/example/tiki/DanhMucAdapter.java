package com.example.tiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DanhMucAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Contact> contactArrayList;
    public DanhMucAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.contactArrayList = (ArrayList<Contact>) objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_danhmuc_row, parent, false);
        TextView tv_icon = convertView.findViewById(R.id.tv_icon);
        TextView tv_item_danhmuc = convertView.findViewById(R.id.tv_item_danhmuc);
        Contact contact = contactArrayList.get(position);
        tv_icon.setBackgroundResource(contact.getIcon());
        tv_item_danhmuc.setText(contact.getName());
        return convertView;
    }
}
