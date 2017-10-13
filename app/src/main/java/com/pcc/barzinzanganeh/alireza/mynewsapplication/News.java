package com.pcc.barzinzanganeh.alireza.mynewsapplication;

/**
 * Created by Alireza Barzin Zanganeh on 10/12/17.
 */

public class News {

    private String mSource;
    private String mAuther;
    private String mTitle;
    private String mDescription;
    private String mURL;
    private String mImageURL;
    private String mPublishedAt;

    public News(String mSource, String mAuther, String mTitle, String mDescription, String mURL, String mImageURL, String mPublishedAt) {
        this.mSource = mSource;
        this.mAuther = mAuther;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mURL = mURL;
        this.mImageURL = mImageURL;
        this.mPublishedAt = mPublishedAt;
    }

    public String getmSource() {
        return mSource;
    }

    public String getmAuther() {
        return mAuther;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmURL() {
        return mURL;
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public String getmPublishedAt() {
        return mPublishedAt;
    }
}
