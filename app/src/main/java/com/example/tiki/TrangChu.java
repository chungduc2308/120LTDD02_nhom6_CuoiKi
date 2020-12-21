package com.example.tiki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;
import product.Product;


public class TrangChu extends AppCompatActivity {
    final String DATABASE_NAME = "Tiki.db";
    SQLiteDatabase database;
    ListView listView;
    ArrayList<SanPham> list;
    AdapterSanpham adapter;
    ViewFlipper viewFlipper;
    RecyclerView rcvCategory, rcvCategory2, rcvCategory3, rcvCategory4;
    CategoryAdapter categoryAdapter, categoryAdapter2, categoryAdapter3, categoryAdapter4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        int[] image_1 = {R.drawable.km1, R.drawable.km2, R.drawable.km3};
        viewFlipper = findViewById(R.id.flip);

        for (int image: image_1){
            flipImage(image);
        }

        addControls();
        readData();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.trangchu);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.trangchu:
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
                        startActivity(new Intent(getApplicationContext(), CaNhan.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        rcvCategory = findViewById(R.id.rcv_category);
        rcvCategory2 = findViewById(R.id.rcv_category2);
        rcvCategory3 = findViewById(R.id.rcv_category3);
        rcvCategory4 = findViewById(R.id.rcv_category4);


        categoryAdapter = new CategoryAdapter(this);
        categoryAdapter2 = new CategoryAdapter(this);
        categoryAdapter3 = new CategoryAdapter(this);
        categoryAdapter4 = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rcvCategory.setLayoutManager(linearLayoutManager);
        rcvCategory2.setLayoutManager(linearLayoutManager2);
        rcvCategory3.setLayoutManager(linearLayoutManager3);
        rcvCategory4.setLayoutManager(linearLayoutManager4);

        categoryAdapter.setData(getListCategory());
        categoryAdapter2.setData(getListCategory2());
        categoryAdapter3.setData(getListCategory3());
        categoryAdapter4.setData(getListCategory4());

        rcvCategory.setAdapter(categoryAdapter);
        rcvCategory2.setAdapter(categoryAdapter2);
        rcvCategory3.setAdapter(categoryAdapter3);
        rcvCategory4.setAdapter(categoryAdapter4);
    }

    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product(R.drawable.noicom, "Nồi cơm Panasonic", "200.000đ"));
        listProduct.add(new Product(R.drawable.sacduphong, "Sạc dự phòng Xiaomi", "1.000.000đ"));
        listProduct.add(new Product(R.drawable.vida, "Ví da bò thật Louis Vuiton", "1.000.000đ"));
        listProduct.add(new Product(R.drawable.noicom, "Nồi cơm Panasonic", "200.000đ"));
        listProduct.add(new Product(R.drawable.sacduphong, "Sạc dự phòng Xiaomi", "1.000.000đ"));

        listCategory.add(new Category("GIÁ SỐC HÔM NAY", listProduct));
        return listCategory;
    }

    private List<Category> getListCategory2(){
        List<Category> listCategory2 = new ArrayList<>();
        List<Product> listProduct2 = new ArrayList<>();
        listProduct2.add(new Product(R.drawable.airpod, "Tai nghe Bluetooth Apple", "3.000.000đ"));
        listProduct2.add(new Product(R.drawable.tainghess, "Tai nghe Samsung A50", "100.000đ"));
        listProduct2.add(new Product(R.drawable.sacduphong, "Sạc dự phòng Xiaomi", "1.000.000đ"));
        listProduct2.add(new Product(R.drawable.vida, "Ví da bò thật Louis Vuiton", "1.000.000đ"));

        listCategory2.add(new Category("HÔM NAY CÓ GÌ HOT", listProduct2));
        return listCategory2;
    }

    private List<Category> getListCategory3(){
        List<Category> listCategory3 = new ArrayList<>();
        List<Product> listProduct3 = new ArrayList<>();
        listProduct3.add(new Product(R.drawable.sandisk_cz50, "USB SanDisk CZ50", "200.000đ"));
        listProduct3.add(new Product(R.drawable.tainghess, "Tai nghe Samsung A50", "100.000đ"));
        listProduct3.add(new Product(R.drawable.sacduphong, "Sạc dự phòng Xiaomi", "1.000.000đ"));
        listProduct3.add(new Product(R.drawable.logitech_g102, "Chuột Logitech G102", "300.000đ"));
        listProduct3.add(new Product(R.drawable.vision_g8, "Bàn phím Vision G8", "300.000đ"));

        listCategory3.add(new Category("YÊU CÔNG NGHỆ", listProduct3));
        return listCategory3;
    }

    private List<Category> getListCategory4(){
        List<Category> listCategory4 = new ArrayList<>();
        List<Product> listProduct4 = new ArrayList<>();
        listProduct4.add(new Product(R.drawable.bphone3, "BPhone 3 64GB", "8.000.000đ"));
        listProduct4.add(new Product(R.drawable.glxnote10, "Galaxy Note 10", "25.000.000đ"));
        listProduct4.add(new Product(R.drawable.glxs10, "Galaxy S10", "25.000.000đ"));
        listProduct4.add(new Product(R.drawable.iphone12, "iPhone 12 64GB", "25.000.000đ"));
        listProduct4.add(new Product(R.drawable.p30, "Huawei P30", "20.000.000đ"));
        listProduct4.add(new Product(R.drawable.redmi8, "Redmi Note 8", "10.000.000đ"));
        listProduct4.add(new Product(R.drawable.vsmart, "VSmart Active 3", "8.000.000đ"));

        listCategory4.add(new Category("ĐIỆN THOẠI", listProduct4));
        return listCategory4;
    }

    public void flipImage(int image_1){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image_1);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2500);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
    }

    private void addControls(){
        listView = findViewById(R.id.list_trangchu);
        list = new ArrayList<>();
        adapter = new AdapterSanpham(this, list);
        listView.setAdapter(adapter);
    }

    private void readData(){
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery(" SELECT * FROM TrangChu ", null);
        list.clear();
        for (int i=0; i<cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String ten = cursor.getString(1);
            String gia = cursor.getString(2);
            byte[] anh = cursor.getBlob(3);
            list.add(new SanPham(id, ten, gia, anh));
        }
        adapter.notifyDataSetChanged();
    }
}