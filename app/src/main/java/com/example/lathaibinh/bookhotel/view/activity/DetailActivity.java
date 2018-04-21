package com.example.lathaibinh.bookhotel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lathaibinh.bookhotel.R;

public class DetailActivity extends AppCompatActivity {
    private TextView mTextViewTenKS;
    private Button mButtonChonPhong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mButtonChonPhong = findViewById(R.id.buttonChonPhong);
        mTextViewTenKS = findViewById(R.id.textViewTenKS);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString(DetailActivity.class.getName());
            mTextViewTenKS.setText(title);
        }
        mButtonChonPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, RoomActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
