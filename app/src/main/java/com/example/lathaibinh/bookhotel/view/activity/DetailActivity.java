package com.example.lathaibinh.bookhotel.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lathaibinh.bookhotel.R;

public class DetailActivity extends AppCompatActivity {
    private TextView mTextViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTextViewTitle = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString(DetailActivity.class.getName());
            mTextViewTitle.setText(title);
        }

    }
}
