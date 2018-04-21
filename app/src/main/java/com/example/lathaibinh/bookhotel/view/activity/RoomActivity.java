package com.example.lathaibinh.bookhotel.view.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lathaibinh.bookhotel.R;
import com.example.lathaibinh.bookhotel.adapter.RoomAdapter;
import com.example.lathaibinh.bookhotel.model.DataRoom;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class RoomActivity extends AppCompatActivity {
    private Button mButtonDat;
    private TextView mTextViewCelendar;
    private Spinner mSpinnerDem;
    private Spinner mSpinnerPhong;
    private Spinner mSpinnerKhach;
    private static final String[]pathsNight = {"1 đêm", "2 đêm", "3 đêm"};
    private static final String[]pathsRoom = {"1 phòng", "2 phòng", "3 phòng"};
    private static final String[]pathsPeople = {"1 khách", "2 khách", "3 khách"};
    Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
//        mButtonDat = findViewById(R.id.buttonDat);
        mTextViewCelendar  = findViewById(R.id.textViewCelendar);
//        mButtonDat.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(RoomActivity.this, BookActivity.class);
////                startActivity(intent);
////                finish();
////            }
////        });
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        mTextViewCelendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RoomActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        mSpinnerDem = findViewById(R.id.spinnerDem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RoomActivity.this,
                android.R.layout.simple_spinner_item,pathsNight);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerDem.setAdapter(adapter);
//        mSpinnerDem.setOnItemSelectedListener();
        mSpinnerKhach = findViewById(R.id.spinnerKhach);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(RoomActivity.this,
                android.R.layout.simple_spinner_item,pathsPeople);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerKhach.setAdapter(adapter1);
        mSpinnerPhong = findViewById(R.id.spinnerPhong);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(RoomActivity.this,
                android.R.layout.simple_spinner_item,pathsRoom);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerPhong.setAdapter(adapter2);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView2);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(RoomActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<DataRoom> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataRoom item = new DataRoom();
            item.setHinhAnh("http://c0.img.chungta.vn/2017/02/09/1-1486610849_660x0.jpg");
            item.setTenPhong("Phòng :" + i);
            item.setThongTinPhong(i+" Khách/phòng");
            item.setGia(i * 2 + 10 + "");
            arrayList.add(item);
        }
        RoomAdapter roomAdapter = new RoomAdapter(arrayList, RoomActivity.this);
        recyclerView.setAdapter(roomAdapter);
    }
    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mTextViewCelendar.setText(sdf.format(myCalendar.getTime()));
    }
}
