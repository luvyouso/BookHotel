package com.example.lathaibinh.bookhotel.model;

import com.example.lathaibinh.bookhotel.R;

public enum ModelObjects {

    Intro1(R.string.introPage_1,R.layout.layout_item1),
    Intro2(R.string.introPage_2,R.layout.layout_item2),
    Intro3(R.string.introPage_3,R.layout.layout_item3);

    private int mTitle;
    private int mLayout;
    ModelObjects(int title,int layout)
    {
        mTitle = title;
        mLayout = layout;
    }
    public int getTitle(){return mTitle;}
    public int getLayout(){return mLayout;}
}
