package com.example.tiki.giohang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tiki.R;

public class Clickgiohang extends AppCompatActivity {

    ImageView imageView,img_trove;
    TextView textView,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickgiohang);

        imageView = findViewById(R.id.img_anhmau_giohang);
        textView = findViewById(R.id.tv_tsp_giohang);
        textView1 = findViewById(R.id.tv_gia_giohang);

        img_trove = findViewById(R.id.img_trove_giohang);
        img_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(com.example.tiki.giohang.Clickgiohang.this, com.example.tiki.giohang.GioHang.class);
                startActivity(i);
            }
        });


        Bundle bundle = getIntent().getExtras();
        Integer logo = bundle.getInt("logo");
        String name = bundle.getString("name");
        String gia = bundle.getString("gia");

        imageView.setImageResource(logo);
        textView.setText(name);
        textView1.setText(gia);

    }
}