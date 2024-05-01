package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView topStoriesRecyclerView;
    private RecyclerView newsRecyclerView;
    private TopStoriesAdapter topStoriesAdapter;
    private NewsAdapter newsAdapter;
    private boolean isTwoPane = false;  // Adjust based on layout/device capabilities

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topStoriesRecyclerView = findViewById(R.id.recycler_top_stories);
        newsRecyclerView = findViewById(R.id.recycler_news);

        // Setup the RecyclerViews with their respective layout managers
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        newsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns in grid

        // Sample data
        ArrayList<NewsStory> topStories = createSampleTopStories();
        ArrayList<NewsStory> newsStories = createSampleNewsStories();

        // Initialize adapters with sample data and set them to the RecyclerViews
        topStoriesAdapter = new TopStoriesAdapter(topStories);
        newsAdapter = new NewsAdapter(newsStories, this::onItemClick);

        topStoriesRecyclerView.setAdapter(topStoriesAdapter);
        newsRecyclerView.setAdapter(newsAdapter);
    }

    private ArrayList<NewsStory> createSampleTopStories() {
        ArrayList<NewsStory> topStories = new ArrayList<>();
        topStories.add(new NewsStory(1, "Nadal waves goodbye after final match", "Tennis legend Rafael Nadal has waved goodbye to fans in emotional scenes after being eliminated from his home tournament.", R.drawable.nadal, new ArrayList<>()));
        topStories.add(new NewsStory(2, "Adrian Newey 'submits resignation' ", "Adrian Newey has moved closer to the Red Bull exit door after submitting his resignation.\n" +
                "\n", R.drawable.adrian, new ArrayList<>()));
        topStories.add(new NewsStory(3, "Lando tipped as the one to challenge Max  ", "One ex-F1 team boss thinks Lando Norris would challenge Max Verstappen if he was at Red Bull.\n" +
                "\n", R.drawable.lando, new ArrayList<>()));

        return topStories;
    }

    private ArrayList<NewsStory> createSampleNewsStories() {
        ArrayList<NewsStory> newsStories = new ArrayList<>();
        newsStories.add(new NewsStory(4, "Australia t20 world cup squad!", "Experience counts as Australian selectors choose veterans including Marcus Stoinis for T20 World Cup", R.drawable.aussie, new ArrayList<>()));
        newsStories.add(new NewsStory(5, "Josh Giddey's heroics help Oklahoma City", "Josh Giddey's final-quarter triple treat in New Orleans has secured a 4-0 sweep and an eight-year NBA first for Oklahoma City.\n" +
                "\n" +
                "The Thunder beat the Pelicans 97-89 on Tuesday (AEST), Giddey (14 points on four-of-six three-pointers) seizing the moment with three clutch triples in a defining fourth-term blitz.", R.drawable.okct, new ArrayList<>()));
        newsStories.add(new NewsStory(6, "Matildas Olympic opponents Zambia could be kicked out", "Zambia's women's national team could be disqualified from the Paris Olympic Games after allegations of money laundering and \"undue influence by third parties\" against the football association's president. ", R.drawable.matils, new ArrayList<>()));
        newsStories.add(new NewsStory(7, "Utd trio off limits as summer fire sale looms", "Manchester United could be in for a huge summer of exits as they plan ahead for a season without the financial benefits of playing in the Champions League.\n" +
                "\n" +
                "Unable to finish ahead of Aston Villa for the first time in Premier League history, it means the Red Devils must begin preparing for a Europa League campaign next season, which brings reduced revenue.\n" +
                "\n", R.drawable.manchester, new ArrayList<>()));


        return newsStories;
    }

    public void onItemClick(NewsStory newsStory) {
        Log.d("MainActivity", "Item Clicked: " + newsStory.getTitle()); // Confirm click is registered

        NewsDetailFragment detailFragment = NewsDetailFragment.newInstance(newsStory.getId());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, detailFragment)
                .addToBackStack(null)
                .commit();
    }

}
