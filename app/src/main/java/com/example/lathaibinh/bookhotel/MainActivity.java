package com.example.lathaibinh.bookhotel;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPagerMain;
    private Button mButtonHome;
    private Button mButtonBook;
    private Button mButtonAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPagerMain = findViewById(R.id.viewPagerMain);
        mButtonHome = findViewById(R.id.buttonHome);
        mButtonBook = findViewById(R.id.buttonBook);
        mButtonAccount = findViewById(R.id.buttonAccount);

        mViewPagerMain.setAdapter(new CustomMainAdapter(this));
        mButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPagerMain.setCurrentItem(0,true);
                mButtonHome.setBackgroundResource(R.color.colorAccent);
                mButtonBook.setBackgroundResource(R.color.colorGray);
                mButtonAccount.setBackgroundResource(R.color.colorGray);
            }
        });
        mButtonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPagerMain.setCurrentItem(1,true);
                mButtonBook.setBackgroundResource(R.color.colorAccent);
                mButtonHome.setBackgroundResource(R.color.colorGray);
                mButtonAccount.setBackgroundResource(R.color.colorGray);
            }
        });
        mButtonAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPagerMain.setCurrentItem(2,true);
                mButtonAccount.setBackgroundResource(R.color.colorAccent);
                mButtonHome.setBackgroundResource(R.color.colorGray);
                mButtonBook.setBackgroundResource(R.color.colorGray);
            }
        });

    }
}
