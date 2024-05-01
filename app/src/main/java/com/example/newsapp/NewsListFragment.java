package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;  // Add this line
import java.util.ArrayList;


public class NewsListFragment extends Fragment {

    private RecyclerView newsRecyclerView;
    private NewsAdapter newsAdapter;

    public NewsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize your RecyclerView
        newsRecyclerView = view.findViewById(R.id.news_recycler_view); // Make sure this ID exists in your fragment_news_list.xml
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Setup the adapter with sample data
        newsAdapter = new NewsAdapter(getSampleNews(), this::onNewsItemClick);
        newsRecyclerView.setAdapter(newsAdapter);
    }

    private List<NewsStory> getSampleNews() {
        // Create and return a list of sample news stories
        ArrayList<NewsStory> sampleNews = new ArrayList<>();
        sampleNews.add(new NewsStory(1, "Sample News Title 1", "This is a summary of the sample news. Replace this text with actual news summary.", R.drawable.sample_image, new ArrayList<>()));
        sampleNews.add(new NewsStory(2, "Sample News Title 2", "This is a summary of the sample news. Replace this text with actual news summary.", R.drawable.sample_image, new ArrayList<>()));
        // Add more sample items...
        return sampleNews;
    }

    private void onNewsItemClick(NewsStory newsStory) {
        // Handle click events on news items
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            activity.onItemClick(newsStory);
        }
    }
}
