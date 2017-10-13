package com.pcc.barzinzanganeh.alireza.mynewsapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pcc.barzinzanganeh.alireza.mynewsapplication.News;
import com.pcc.barzinzanganeh.alireza.mynewsapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alireza Barzin Zanganeh on 10/12/17.
 */

public class AdapterNews extends ArrayAdapter<News> {
    private Activity activity;
    private ArrayList<News> lNews;
    private static LayoutInflater inflater = null;

    public AdapterNews (Activity activity, int textViewResourceId, ArrayList<News> _lNews) {
        super(activity, textViewResourceId, _lNews);

        this.activity = activity;
        this.lNews = _lNews;

        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return lNews.size();
    }
    public News getItem(News position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView source_title;
        public TextView title_context;
        public TextView author_context;
        public WebView url_image;
        public TextView description_context;
        public TextView url_link;
        public TextView published_date;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.articles_list, null);
                holder = new ViewHolder();

                holder.source_title = (TextView) vi.findViewById(R.id.source_title);
                holder.title_context = (TextView) vi.findViewById(R.id.title_context);
                holder.author_context = (TextView) vi.findViewById(R.id.author_context);
                holder.url_image = (WebView) vi.findViewById(R.id.url_image);
                holder.description_context = (TextView) vi.findViewById(R.id.description_context);
                holder.url_link = (TextView) vi.findViewById(R.id.url_link);
                holder.published_date = (TextView) vi.findViewById(R.id.published_date);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }
            holder.source_title.setText(lNews.get(position).getmSource());
            holder.title_context.setText(lNews.get(position).getmTitle());
            holder.author_context.setText(lNews.get(position).getmAuther());
            holder.url_image.loadUrl(lNews.get(position).getmImageURL());
            holder.description_context.setText(lNews.get(position).getmDescription());
            holder.url_link.setText(lNews.get(position).getmURL());
            holder.published_date.setText(lNews.get(position).getmPublishedAt());


        } catch (Exception e) {


        }
        return vi;
    }
    public AdapterNews(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public AdapterNews(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public AdapterNews(@NonNull Context context, @LayoutRes int resource, @NonNull News[] objects) {
        super(context, resource, objects);
    }

    public AdapterNews(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull News[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public AdapterNews(@NonNull Context context, @LayoutRes int resource, @NonNull List<News> objects) {
        super(context, resource, objects);
    }

    public AdapterNews(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<News> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
