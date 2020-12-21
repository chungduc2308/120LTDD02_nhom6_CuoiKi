package com.example.tiki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DanhMuc extends AppCompatActivity {
    private RecyclerView rcvUser;
    private UserAdapter mUserAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);
        rcvUser = findViewById(R.id.rcv_user);
        mUserAdapter = new UserAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        rcvUser.setLayoutManager(gridLayoutManager);

        mUserAdapter.setData(getListUser());
        rcvUser.setAdapter(mUserAdapter);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.danhmuc);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.trangchu:
                        startActivity(new Intent(getApplicationContext(), TrangChu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.danhmuc:
                        return true;
                    case R.id.luot:
                        startActivity(new Intent(getApplicationContext(), Luot.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.chat:
                        startActivity(new Intent(getApplicationContext(), Chat.class));
                        overridePendingTransition(0,0);
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
    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.a_1, "Loai 1"));
        list.add(new User(R.drawable.a_2, "Loai 2"));
        list.add(new User(R.drawable.a_3, "Loai 3"));
        list.add(new User(R.drawable.a_4, "Loai 4"));
        list.add(new User(R.drawable.a_5, "Loai 5"));

        list.add(new User(R.drawable.dt1, "Loai 6"));
        list.add(new User(R.drawable.dt2, "Loai 7"));
        list.add(new User(R.drawable.dt3, "Loai 8"));
        list.add(new User(R.drawable.dt4, "Loai 9"));
        list.add(new User(R.drawable.dt5, "Loai 10"));

        list.add(new User(R.drawable.m1, "Loai 11"));
        list.add(new User(R.drawable.m2, "Loai 12"));
        list.add(new User(R.drawable.m3, "Loai 13"));
        list.add(new User(R.drawable.m4, "Loai 14"));
        list.add(new User(R.drawable.m5, "Loai 15"));

        list.add(new User(R.drawable.x1, "Loai 11"));
        list.add(new User(R.drawable.x2, "Loai 12"));
        list.add(new User(R.drawable.x3, "Loai 13"));
        list.add(new User(R.drawable.x4, "Loai 14"));
        list.add(new User(R.drawable.x5, "Loai 15"));



        return list;
    }
}