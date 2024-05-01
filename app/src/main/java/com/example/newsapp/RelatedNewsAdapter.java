package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {
    private List<NewsStory> relatedNews;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.text_title); // Ensure you have text_title in your item layout
        }
    }

    public RelatedNewsAdapter(List<NewsStory> relatedNews) {
        this.relatedNews = relatedNews;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsStory newsStory = relatedNews.get(position);
        holder.titleTextView.setText(newsStory.getTitle());
    }

    @Override
    public int getItemCount() {
        return relatedNews != null ? relatedNews.size() : 0;
    }
}
