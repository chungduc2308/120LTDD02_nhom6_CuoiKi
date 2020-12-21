package com.example.tiki;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerLuotAdapter extends FragmentStatePagerAdapter {

    public ViewPagerLuotAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new KhamPhaFragment();
            case 1:
                return new QuanTamFragment();
            default:
                return new KhamPhaFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Khám Phá";
                break;
            case 1:
                title = "Quan Tâm";
                break;
        }
        return title;
    }
}
