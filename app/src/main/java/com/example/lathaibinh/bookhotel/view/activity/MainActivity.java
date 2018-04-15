package com.example.lathaibinh.bookhotel.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.lathaibinh.bookhotel.adapter.MainAdapter;
import com.example.lathaibinh.bookhotel.R;
import com.example.lathaibinh.bookhotel.view.fragment.AccountFragment;
import com.example.lathaibinh.bookhotel.view.fragment.HistoryFragment;
import com.example.lathaibinh.bookhotel.view.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ViewPager mViewPagerMain;
    private MainAdapter mMainAdapter;
    private BottomNavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPagerMain = findViewById(R.id.viewPagerMain);
        mNavigationView= (BottomNavigationView) findViewById(R.id.navigation);
        mNavigationView.setOnNavigationItemSelectedListener(this);
        mMainAdapter = new MainAdapter(getSupportFragmentManager());
        mMainAdapter.addFragment(new HomeFragment(),"Home");
        mMainAdapter.addFragment(new HistoryFragment(),"History");
        mMainAdapter.addFragment(new AccountFragment(),"Account");

        mViewPagerMain.setAdapter(mMainAdapter);

        mViewPagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


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
