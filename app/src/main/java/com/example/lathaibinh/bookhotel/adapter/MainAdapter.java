package com.example.lathaibinh.bookhotel.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;

    public MainAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void addFragment(Fragment fragment,String title) {
        mFragments.add(fragment);
        notifyDataSetChanged();
    }
}
