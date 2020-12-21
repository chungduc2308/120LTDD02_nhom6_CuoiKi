package com.example.tiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiki.chat.Model;
import com.example.tiki.chat.MyAdapter;
import com.example.tiki.giohang.GioHang;
import com.example.tiki.chat.MyAdapter;
import com.example.tiki.giohang.GioHang;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {

    RecyclerView recyclerView_chat;
    MyAdapter myAdapter;
    ImageView quaylai, shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        quaylai = findViewById(R.id.quaylai);
        shop = findViewById(R.id.shop);

        recyclerView_chat = findViewById(R.id.recyclerview_chat);
        recyclerView_chat.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, getMyList());
        recyclerView_chat.setAdapter(myAdapter);

        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(com.example.tiki.Chat.this,TrangChu.class);
                startActivity(i);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(com.example.tiki.Chat.this, GioHang.class);
                startActivity(i);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.chat);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(), TrangChu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.danhmuc:
                        startActivity(new Intent(getApplicationContext(), DanhMuc.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.luot:
                        startActivity(new Intent(getApplicationContext(), Luot.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.chat:
                        return true;
                    case R.id.canhan:
                        startActivity(new Intent(getApplicationContext(), CaNhan.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    private ArrayList<Model> getMyList(){

        ArrayList<Model> models = new ArrayList<>();
        Model m = new Model();
        m.setImg_anhmau(R.drawable.balo);
        m.setTv_tsp("Balo chống nước...");
        m.setTv_ts("Shop Đà Nẵng");
        m.setBt_chat("Chat");
        models.add(m);

        m = new Model();
        m.setImg_anhmau(R.drawable.ao);
        m.setTv_tsp("Áo Da Thời Thượng...");
        m.setTv_ts("Shop Hồ Chí Minh");
        m.setBt_chat("Chat");
        models.add(m);

        m = new Model();
        m.setImg_anhmau(R.drawable.quan);
        m.setTv_tsp("Quần jean Cao Cấp...");
        m.setTv_ts("Shop Đà Lạt");
        m.setBt_chat("Chat");
        models.add(m);

        m = new Model();
        m.setImg_anhmau(R.drawable.sach);
        m.setTv_tsp("Sách Mắt Biếc...");
        m.setTv_ts("Shop Hà Nội");
        m.setBt_chat("Chat");
        models.add(m);

        m = new Model();
        m.setImg_anhmau(R.drawable.giay);
        m.setTv_tsp("Giày Thể Thao...");
        m.setTv_ts("Shop Nước Ngoài");
        m.setBt_chat("Chat");
        models.add(m);

        m = new Model();
        m.setImg_anhmau(R.drawable.sach2);
        m.setTv_tsp("Tắt Đèn...");
        m.setTv_ts("Shop Đà Nẵng");
        m.setBt_chat("Chat");
        models.add(m);


        return models;
    }

}