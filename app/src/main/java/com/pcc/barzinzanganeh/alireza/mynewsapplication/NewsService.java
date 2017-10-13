package com.pcc.barzinzanganeh.alireza.mynewsapplication;

import android.nfc.Tag;
import android.telecom.Call;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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

    public static ArrayList<News> processResults(String responseJSON){
        ArrayList<News> newsArticles = new ArrayList<>();
        try {
            JSONObject rootJSON = new JSONObject(responseJSON);
            String source = rootJSON.getString("source");
            JSONArray articlesJSON = rootJSON.getJSONArray("articles");

            for (int i = 0; i < articlesJSON.length(); i++) {
                try {
                    JSONObject tempJSON = articlesJSON.getJSONObject(i);
                    String author = tempJSON.getString("author");

                    String title = tempJSON.getString("title");
                    String description = tempJSON.getString("description");
                    String url = tempJSON.getString("url");
                    String imageUrl = tempJSON.getString("urlToImage");
                    String publishedAt = tempJSON.getString("publishedAt");
                    News newsArticle = new News(source, author, title, description, url, imageUrl, publishedAt);
                    newsArticles.add(newsArticle);
                    String temp = newsArticle.getmTitle();
                    Log.d("news articles: " + i + " ------ ",temp );
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return newsArticles;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
