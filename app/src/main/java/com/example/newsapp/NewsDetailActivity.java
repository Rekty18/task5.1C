package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class NewsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        ImageView imageView = findViewById(R.id.image_news);
        TextView titleView = findViewById(R.id.text_title);
        TextView descriptionView = findViewById(R.id.text_description);
        RecyclerView relatedNewsRecyclerView = findViewById(R.id.recycler_related_news);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        int imageResId = intent.getIntExtra("imageResId", 0);

        titleView.setText(title);
        descriptionView.setText(description);
        imageView.setImageResource(imageResId);

        // Prepare the list of related news
        List<NewsStory> relatedNews = getRelatedNews(); // This method should fetch related news based on current news details or id

        // Setup the adapter for related news
        RelatedNewsAdapter adapter = new RelatedNewsAdapter(relatedNews);
        relatedNewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        relatedNewsRecyclerView.setAdapter(adapter);
    }

    private List<NewsStory> getRelatedNews() {
        return Arrays.asList(
                new NewsStory(1, "Premier league spending cap", "Premier League clubs back plan to look at spending cap\n", R.drawable.pl, null)

        );
    }
}
