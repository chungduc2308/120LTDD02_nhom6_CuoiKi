package com.example.tiki.giohang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiki.Chat;
import com.example.tiki.R;
import com.example.tiki.TrangChu;
import com.example.tiki.TrangChu;

import java.util.ArrayList;

public class GioHang extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    ImageView dong;
    Button bt_muasam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        recyclerView = findViewById(R.id.recyclerview_giohang);

        dong = findViewById(R.id.dong);
        bt_muasam = findViewById(R.id.bt_muasam);

        dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(com.example.tiki.giohang.GioHang.this, Chat.class);
                startActivity(i);
            }
        });
        bt_muasam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(com.example.tiki.giohang.GioHang.this, TrangChu.class);
                startActivity(i);
            }
        });

        Integer[] langLogo = {R.drawable.sach,R.drawable.ao,R.drawable.quan,R.drawable.giay,
                R.drawable.sach2,R.drawable.balo,R.drawable.quan};

        String[] langName = {"Mắt Biếc...","Áo Thun Trơn...","Quần Thời Trang...","Giày Thể Thao...",
                "Tắt Đèn...","Balo Thời Trang...","Quần Jocker..."};

        String[] langGia = {"200.000VNĐ","240.000VNĐ","400.000VNĐ","620.000VNĐ",
                "210.000VNĐ","150.000VNĐ","900.000VNĐ"};

        mainModels = new ArrayList<>();
        for (int i=0;i<langLogo.length;i++){
            MainModel model = new MainModel(langLogo[i],langName[i],langGia[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                com.example.tiki.giohang.GioHang.this, LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter = new MainAdapter(com.example.tiki.giohang.GioHang.this,mainModels);
        recyclerView.setAdapter(mainAdapter);


    }
}