package com.example.lathaibinh.bookhotel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lathaibinh.bookhotel.R;

public class RoomActivity extends AppCompatActivity {
    private Button mButtonDat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        mButtonDat = findViewById(R.id.buttonDat);
        mButtonDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomActivity.this, BookActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
