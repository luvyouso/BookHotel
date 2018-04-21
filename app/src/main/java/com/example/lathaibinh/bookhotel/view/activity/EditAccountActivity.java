package com.example.lathaibinh.bookhotel.view.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lathaibinh.bookhotel.R;
import com.squareup.picasso.Picasso;
import com.werb.permissionschecker.PermissionChecker;
import com.werb.pickphotoview.PickPhotoView;
import com.werb.pickphotoview.util.PickConfig;

import java.util.ArrayList;

public class EditAccountActivity extends AppCompatActivity {
    private Button mButtonHuyEdit;
    private ImageView mImagePhoto;
    private Button mButtonDoiHinh;
    private PermissionChecker permissionChecker;
    private String[] PERMISSIONS = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        mButtonHuyEdit = findViewById(R.id.buttonHuyEdit);
        mButtonHuyEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        mImagePhoto  = findViewById(R.id.ImagePhoto);
        mButtonDoiHinh = findViewById(R.id.buttonSuaHinh);
        permissionChecker = new PermissionChecker(this);
        if (permissionChecker.isLackPermissions(PERMISSIONS)) {
            permissionChecker.requestPermissions();
        }

        mButtonDoiHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PickPhotoView.Builder(EditAccountActivity.this)
                        .setPickPhotoSize(1)                  // select image size
                        .setClickSelectable(true)             // click one image immediately close and return image
                        .setShowCamera(true)                  // is show camera
                        .setSpanCount(3)                      // span count
                        .setLightStatusBar(true)              // lightStatusBar used in Android M or higher
                        .setStatusBarColor(R.color.colorPrimaryDark)     // statusBar color
                        .setToolbarColor(R.color.colorPrimaryDark)       // toolbar color
                        .setToolbarTextColor(R.color.colorWhite)   // toolbar text color
                        .setSelectIconColor(R.color.colorWhite)     // select icon color
                        .setShowGif(false)                    // is show gif
                        .start();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 0){
            return;
        }
        if(data == null){
            return;
        }
        if (requestCode == PickConfig.INSTANCE.getPICK_PHOTO_DATA()) {
            ArrayList<String> selectPaths = (ArrayList<String>) data.getSerializableExtra(PickConfig.INSTANCE.getINTENT_IMG_LIST_SELECT());
            Picasso.get()
                    .load("file:///"+selectPaths.get(0))
                    .centerCrop()
                    .fit()
                    .into(mImagePhoto);
        }
    }
    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionChecker.PERMISSION_REQUEST_CODE:
                if (!permissionChecker.hasAllPermissionsGranted(grantResults)) {
                    permissionChecker.showDialog();
                }
                break;
        }
    }
}
