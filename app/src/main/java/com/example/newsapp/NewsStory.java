package com.example.newsapp;

import java.util.List;

public class NewsStory {
    private int id;
    private String title;
    private String description; // Renamed variable for clarity
    private int imageResource;
    private List<NewsStory> relatedNews;

    public NewsStory(int id, String title, String description, int imageResource, List<NewsStory> relatedNews) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.relatedNews = relatedNews;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() { // Renamed getter
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public List<NewsStory> getRelatedNews() {
        return relatedNews;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) { // Renamed setter
        this.description = description;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setRelatedNews(List<NewsStory> relatedNews) {
        this.relatedNews = relatedNews;
    }
}
