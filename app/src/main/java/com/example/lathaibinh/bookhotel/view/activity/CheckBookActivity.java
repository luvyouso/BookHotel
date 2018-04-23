package com.example.lathaibinh.bookhotel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lathaibinh.bookhotel.R;

public class CheckBookActivity extends AppCompatActivity {
    private Button mButtonAccept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_book);
        mButtonAccept = findViewById(R.id.buttonAcceptCheckBook);
        mButtonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(CheckBookActivity.this,PaymentActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
