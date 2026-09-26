package com.example.laps.api;

import java.util.List;
import com.example.laps.Video; // Assuming you might fetch a list of videos

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    
    // Example endpoint - this should match the path to your PHP script in WAMP
    // e.g., http://10.0.2.2/api/get_videos.php
    @GET("api/get_videos.php")
    Call<List<Video>> getVideos();

}
