package com.example.fragmentbestpractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private boolean isTwoPane;
    private List<News> newsList;
    private NewsAdapter adapter;
    private ListView newsTitleView;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        newsList=getNews();
        adapter =new NewsAdapter(activity,R.layout.news_item,newsList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleView =(ListView)
                view.findViewById(R.id.news_title_recycler_view);
        newsTitleView.setAdapter(adapter);
        newsTitleView.setOnItemClickListener ((AdapterView.OnItemClickListener) this);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstancedState){
        super.onActivityCreated(savedInstancedState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null) {
            isTwoPane = true;
        }else{
            isTwoPane=false;
        }
    }
    @Override
    public void onItemClick(AdapterView<?>parent,View view,int position,long id){
        News news=newsList.get(position);
        if(isTwoPane) {
            NewsContentFragment newsContentFragment = (NewsContentFragment)
                    getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(), news.getContent());
        }else{
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getTitle());
        }
    }
    private List<News> getNews(){
        List<News> newsList= new ArrayList<>();
        for (int i = 1;i <= 50;i++){
            News news = new News();
            news.setTitle("This is news title"+i);
            news.setContent(getRandomLengthContent ("This is news content"+i+"."));
            newsList.add(news);
        }
        return newsList;
    }
    private String getRandomLengthContent(String content){
        Random random=new Random();
        int length =random.nextInt(5)+1;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length; i++){
            builder.append(content);
        }
        return builder.toString();
    }

}
