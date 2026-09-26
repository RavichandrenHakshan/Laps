package com.example.laps;

public class Video {
    private String title;
    private String channelName;
    private String views;
    private String date;
    private String thumbnailUrl;
    private String videoUrl;

    public Video(String title, String channelName, String views, String date, String thumbnailUrl, String videoUrl) {
        this.title = title;
        this.channelName = channelName;
        this.views = views;
        this.date = date;
        this.thumbnailUrl = thumbnailUrl;
        this.videoUrl = videoUrl;
    }

    public String getTitle() { return title; }
    public String getChannelName() { return channelName; }
    public String getViews() { return views; }
    public String getDate() { return date; }
    public String getThumbnailUrl() { return thumbnailUrl; }
    public String getVideoUrl() { return videoUrl; }
}
