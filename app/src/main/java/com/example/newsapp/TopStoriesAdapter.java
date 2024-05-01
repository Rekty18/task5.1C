package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoryViewHolder> {

    private final List<NewsStory> topStories;

    public static class TopStoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public TopStoryViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            textView = view.findViewById(R.id.title);
        }
    }

    public TopStoriesAdapter(List<NewsStory> topStories) {
        this.topStories = topStories;
    }

    @Override
    public TopStoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_story, parent, false);
        return new TopStoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopStoryViewHolder holder, int position) {
        NewsStory story = topStories.get(position);
        holder.textView.setText(story.getTitle());
        holder.imageView.setImageResource(story.getImageResource());
    }

    @Override
    public int getItemCount() {
        return topStories.size();
    }
}
