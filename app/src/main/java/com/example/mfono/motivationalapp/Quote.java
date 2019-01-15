package com.example.mfono.motivationalapp;

import android.util.Log;

public class Quote{

    private String mQuotes;
    private String mAuthor;
    private static final String TAG = "Quote";


    public Quote(String quotes, String author){
        this.mQuotes = quotes;
        this.mAuthor = author;
    }

    public String getmAuthor() {
        Log.d(TAG, "Author value is : " + mAuthor);
        return mAuthor;
    }

    public String getmQuotes() {
        Log.d(TAG, "Quote value is : " + mQuotes);
        return mQuotes;
    }
}
