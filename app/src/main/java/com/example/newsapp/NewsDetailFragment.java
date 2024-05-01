package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsDetailFragment extends Fragment {
    private static final String ARG_NEWS_ID = "news_id";

    private TextView newsTitle;
    private ImageView newsImage;
    private TextView newsSummary;
    private RecyclerView relatedNewsRecyclerView;
    private NewsAdapter relatedNewsAdapter;

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    public static NewsDetailFragment newInstance(int newsId) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NEWS_ID, newsId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        newsTitle = view.findViewById(R.id.detail_news_title);
        newsImage = view.findViewById(R.id.detail_news_image);
        newsSummary = view.findViewById(R.id.detail_news_summary);
        relatedNewsRecyclerView = view.findViewById(R.id.recycler_related_stories);  // Updated ID here

        // Setup RecyclerView for related news
        relatedNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        relatedNewsAdapter = new NewsAdapter(new ArrayList<>(), this::handleRelatedNewsClick);
        relatedNewsRecyclerView.setAdapter(relatedNewsAdapter);

        // Retrieve and display news details
        int newsId = getArguments() != null ? getArguments().getInt(ARG_NEWS_ID, 0) : 0;
        displayNewsDetails(newsId);
    }


    private void handleRelatedNewsClick(NewsStory newsStory) {
        // Handle clicks on related news items, for example, by refreshing this fragment with new news details
        getParentFragmentManager().beginTransaction()
                .replace(R.id.container, newInstance(newsStory.getId()))
                .addToBackStack(null)
                .commit();
    }

    private void displayNewsDetails(int newsId) {
        // Placeholder for fetching news details based on ID
        // Implement actual data fetching logic here
        NewsStory news = fetchNewsById(newsId);
        if (news != null) {
            newsTitle.setText(news.getTitle());
            newsSummary.setText(news.getDescription());
            newsImage.setImageResource(news.getImageResource());
            relatedNewsAdapter.updateData(news.getRelatedNews());
        } else {
            newsTitle.setText("News not found");
            newsSummary.setText("No details available for the selected news.");
            newsImage.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    private NewsStory fetchNewsById(int newsId) {
        // Simulate fetching news by ID. Replace with real data fetching.
        // This is a placeholder.
        return new NewsStory(newsId, "Sample News Title", "This is a sample summary for news ID " + newsId, R.drawable.ic_launcher_background, new ArrayList<>());
    }
}
