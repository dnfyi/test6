package com.example.fragmentbestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    private int resourceId;
    public NewsAdapter(Context context, int textViewResourceId, List<News> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        News news=getItem(position);//获取相应位置上的News类，并让新闻的标题在列表中进行显示。
        View view;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        }
        else {
            view=convertView;
        }
        TextView newsTitleText=(TextView)
                view.findViewById(R.id.news_title);
        newsTitleText.setText(news.getTitle());
        return view;

    }
}