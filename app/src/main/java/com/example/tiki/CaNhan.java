package com.example.tiki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CaNhan extends AppCompatActivity {
    private ListView listView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_nhan);
        listView = findViewById(R.id.list_danhmuc);
        textView = findViewById(R.id.txv_login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CaNhan.this, Login_SignUp.class);
                startActivity(intent);
            }
        });
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        Contact contact = new Contact(R.drawable.category,"Quản lý đơn hàng");
        Contact contact_1 = new Contact(R.drawable.cart_1,"Sản phẩm đã mua");
        Contact contact_2 = new Contact(R.drawable.eye_view,"Sản phẩm đã xem");
        Contact contact_3 = new Contact(R.drawable.favourite_heart,"Sản phẩm yêu thích");
        Contact contact_4 = new Contact(R.drawable.bookmark,"Sản phẩm mua sau");
        Contact contact_5 = new Contact(R.drawable.credit_card,"Ưu đãi cho chủ thẻ ngân hàng");
        Contact contact_6 = new Contact(R.drawable.setting,"Cài đặt");
        contactArrayList.add(contact);
        contactArrayList.add(contact_1);
        contactArrayList.add(contact_2);
        contactArrayList.add(contact_3);
        contactArrayList.add(contact_4);
        contactArrayList.add(contact_5);
        contactArrayList.add(contact_6);
        DanhMucAdapter danhMucAdapter =new DanhMucAdapter(this,R.layout.item_danhmuc_row,contactArrayList);
        listView.setAdapter(danhMucAdapter);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.canhan);
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
                        startActivity(new Intent(getApplicationContext(), Chat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.canhan:
                        return true;
                }
                return false;
            }
        });
    }
}