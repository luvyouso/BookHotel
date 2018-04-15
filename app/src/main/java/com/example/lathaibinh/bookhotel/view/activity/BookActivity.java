package com.example.lathaibinh.bookhotel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lathaibinh.bookhotel.R;

public class BookActivity extends AppCompatActivity {
    private Button mButtonDienThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        mButtonDienThongTin  = findViewById(R.id.buttonDienThongTinLienHe);
        mButtonDienThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(BookActivity.this,InfoActivity.class);
                startActivity(inten);
                finish();
            }
        });
    }
}
