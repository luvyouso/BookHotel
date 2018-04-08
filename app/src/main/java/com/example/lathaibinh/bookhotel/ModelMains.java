package com.example.lathaibinh.bookhotel;

public enum ModelMains {

    Home(R.string.mainPage_home,R.layout.layout_home),
    Book(R.string.mainPage_book,R.layout.layout_book),
    Account(R.string.mainPage_account,R.layout.layout_account);

    private int mTitle;
    private int mLayout;
    ModelMains(int title,int layout)
    {
        mTitle = title;
        mLayout = layout;
    }
    public int getTitle(){return mTitle;}
    public int getLayout(){return mLayout;}
}
