package com.example.lathaibinh.bookhotel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lathaibinh.bookhotel.R;

public class InfoActivity extends AppCompatActivity {
    private Button mButtonHuy;
    private Button mButtonAccept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mButtonAccept=findViewById(R.id.buttonAcceptInfo);
        mButtonHuy = findViewById(R.id.buttonHuyInfo);
        mButtonHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(InfoActivity.this,BookActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
