package com.example.tiki;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

public class AdapterSanpham extends BaseAdapter {
    Activity context;
    ArrayList<SanPham> list;

    public AdapterSanpham(Activity context, ArrayList<SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item_trangchu, null);
        ImageView imageView = row.findViewById(R.id.img_icon);
        TextView tv_id = row.findViewById(R.id.tv_item_id);
        TextView tv_name = row.findViewById(R.id.tv_item_ten);
        TextView tv_price = row.findViewById(R.id.tv_item_gia);

        SanPham sanPham = list.get(position);
        tv_id.setText(sanPham.id + "");
        tv_name.setText(sanPham.ten);
        tv_price.setText(sanPham.gia);

        Bitmap bmHinh = BitmapFactory.decodeByteArray(sanPham.anh, 0, sanPham.anh.length);
        imageView.setImageBitmap(bmHinh);

        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailTrangChu.class);
                i.putExtra("id", sanPham.id);
                context.startActivity(i);
            }
        });
        return row;
    }
}
