package com.example.fragmentbestpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NewsContentFragment extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view =inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    public void refresh(String newsTitle,String newsContent){
        //用于显示新闻标题和内容
        View visibilityLayout=view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);//设置可见
        TextView newsTitleText=(TextView)
                view.findViewById(R.id.news_title);//获取标题控件
        TextView newsContentText=(TextView)
                view.findViewById(R.id.news_content);//获取正文控件
        newsTitleText.setText(newsTitle);//刷新新闻标题
        newsContentText.setText(newsContent);//刷新新闻内容
    }
}
