package com.pcc.barzinzanganeh.alireza.mynewsapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.pcc.barzinzanganeh.alireza.mynewsapplication.adapters.AdapterNews;
import java.io.IOException;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = this.getClass().getSimpleName();

    private Activity mContext;
    AdapterNews adNews;

    @BindView(R.id.bbc_button) Button mBbcButton;
    @BindView(R.id.cnn_button) Button mCnnButton;
    @BindView(R.id.time_button) Button mTimeButton;
    @BindView(R.id.articles_list_view) ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBbcButton.setOnClickListener(this);
        mCnnButton.setOnClickListener(this);
        mTimeButton.setOnClickListener(this);

        mContext = this;

    }

    @Override
    public void onClick(View v) {
         Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "It doesn't work");
            }

            @Override
            public void onResponse(Call call, Response response) {
                Log.d(TAG, "It works!");
                try {
                    String responseJSON = response.body().string();
                    if(response.isSuccessful()){
                        Log.d(TAG, responseJSON);
                        final ArrayList<News> newsArticles = NewsService.processResults(responseJSON);

                        mContext.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adNews = new AdapterNews(MainActivity.this, 0, newsArticles );
                                 mListView.setAdapter(adNews);
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        String mNewsSource = null;
        switch(v.getId()) {
            case R.id.bbc_button:
                Log.d(TAG,"BBC clicked!");
                mNewsSource = "bbc-news";
                Log.d("mNewsSource: ", mNewsSource);
                break;
            case R.id.cnn_button:
//                Log.d(TAG,"CNN clicked!");
                mNewsSource = "cnn";
//                Log.d("mNewsSource: ", mNewsSource);
                break;
            case R.id.time_button:
//                Log.d(TAG,"Time clicked!");
                mNewsSource = "time";
//                Log.d("mNewsSource: ", mNewsSource);
                break;
        }
        NewsService.newsServiceCall(mNewsSource, callback);
    }

}
