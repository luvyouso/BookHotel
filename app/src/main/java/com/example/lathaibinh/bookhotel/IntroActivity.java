package com.example.lathaibinh.bookhotel;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {

    private ViewPager mViewPagerIntro;
    private Button mButtonLeft;
    private Button mButtonRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mViewPagerIntro = findViewById(R.id.viewPagerIntro);
        mButtonLeft = findViewById(R.id.buttonLeft);
        mButtonRight = findViewById(R.id.buttonRight);

        mViewPagerIntro.setAdapter(new CustomPageAdapter(this));
        mViewPagerIntro.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {//end
                    mButtonLeft.setVisibility(View.GONE);
                    mButtonRight.setVisibility(View.GONE);
                    Button mButtonStar= findViewById(R.id.buttonStar);
                    mButtonStar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                else
                {
                    mButtonLeft.setVisibility(View.VISIBLE);
                    mButtonRight.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        mButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mViewPagerIntro.setCurrentItem(2);
               int position = mViewPagerIntro.getCurrentItem();
               mViewPagerIntro.setCurrentItem(position+1,true);
            }
        });
    }
}
