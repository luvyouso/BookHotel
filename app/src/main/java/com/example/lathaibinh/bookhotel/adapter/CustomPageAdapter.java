package com.example.lathaibinh.bookhotel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lathaibinh.bookhotel.model.ModelObjects;

public class CustomPageAdapter extends PagerAdapter{
    private Context mContext;

    public CustomPageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ModelObjects modelObject = ModelObjects.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayout(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ModelObjects.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ModelObjects customPagerEnum = ModelObjects.values()[position];

        return mContext.getString(customPagerEnum.getTitle());
    }
}
