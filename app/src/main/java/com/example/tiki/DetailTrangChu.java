package com.example.tiki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailTrangChu extends AppCompatActivity {
    final String DATABASE_NAME = "Tiki.db";
    ImageView imageView;
    TextView ten,gia;
    Button bt_mua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_trang_chu);

        addControls();
        initUI();

    }

    public void addControls(){
        imageView = findViewById(R.id.img_detail);
        ten = findViewById(R.id.tv_ten_detail);
        gia = findViewById(R.id.tv_gia_detail);
    }

    public void initUI(){
        Intent i = getIntent();
        int id = i.getIntExtra("id", -1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery(" SELECT * FROM TrangChu WHERE id = ?", new String[]{id + ""});
        cursor.moveToFirst();
        String tv_ten = cursor.getString(1);
        String tv_gia = cursor.getString(2);
        byte[] anh = cursor.getBlob(3);

        Bitmap bitmap = BitmapFactory.decodeByteArray(anh, 0, anh.length);
        imageView.setImageBitmap(bitmap);
        ten.setText(tv_ten);
        gia.setText(tv_gia);
    }
}