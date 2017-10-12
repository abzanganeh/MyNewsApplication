package com.pcc.barzinzanganeh.alireza.mynewsapplication;

import android.telecom.Call;
import android.util.Log;

import javax.security.auth.callback.Callback;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Alireza Barzin Zanganeh on 10/11/17.
 */

public class NewsService {
    public static void newsServiceCall(String newsSource, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        String myUrl = "https://newsapi.org/v1/articles?source=" + newsSource + "&apiKey=79572be2c98a4bd48b440650f8deb2ec";
        Log.d("URL: ", myUrl);
        Request request = new Request.Builder().url(myUrl).build();
        okhttp3.Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
