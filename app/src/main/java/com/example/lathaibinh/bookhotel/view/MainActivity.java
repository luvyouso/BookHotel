package com.example.lathaibinh.bookhotel.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.lathaibinh.bookhotel.adapter.CustomMainAdapter;
import com.example.lathaibinh.bookhotel.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ViewPager mViewPagerMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPagerMain = findViewById(R.id.viewPagerMain);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        mViewPagerMain.setAdapter(new CustomMainAdapter(this));

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mViewPagerMain.setCurrentItem(0, true);
                return true;
            case R.id.navigation_dashboard:
                mViewPagerMain.setCurrentItem(1, true);
                return true;
            case R.id.navigation_notifications:
                mViewPagerMain.setCurrentItem(2, true);
                return true;
        }
        return false;
    }
}
