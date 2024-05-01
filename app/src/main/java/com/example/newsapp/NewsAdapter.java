package com.example.newsapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<NewsStory> newsList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(NewsStory newsStory);
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        // Simplified constructor, listener directly set in onBindViewHolder
        public NewsViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.news_image);
            textView = itemView.findViewById(R.id.news_title);
        }
    }

    public NewsAdapter(List<NewsStory> newsList, OnItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_story, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final NewsStory newsStory = newsList.get(position);
        holder.textView.setText(newsStory.getTitle());
        holder.imageView.setImageResource(newsStory.getImageResource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewsDetailActivity.class);
                intent.putExtra("title", newsStory.getTitle());
                intent.putExtra("description", newsStory.getDescription()); // Assuming getDescription() exists
                intent.putExtra("imageResId", newsStory.getImageResource());
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void updateData(List<NewsStory> newNewsList) {
        if (newNewsList != null) {
            newsList.clear();  // Clear the existing data
            newsList.addAll(newNewsList);  // Add all the new data
            notifyDataSetChanged();  // Notify the adapter that the data set has changed
        }
    }
}
