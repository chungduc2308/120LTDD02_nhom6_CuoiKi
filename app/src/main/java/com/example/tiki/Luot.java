package com.example.tiki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class Luot extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luot);
        mTabLayout =findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        ViewPagerLuotAdapter viewPagerLuotAdapter = new ViewPagerLuotAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerLuotAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.luot);
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
}