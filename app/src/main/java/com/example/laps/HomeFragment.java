package com.example.laps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    
    private RecyclerView recyclerView;
    private VideoAdapter adapter;
    private List<Video> videoList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        
        recyclerView = view.findViewById(R.id.recyclerView_videos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        videoList = new ArrayList<>();
        // Add dummy videos
        videoList.add(new Video(
            "Big Buck Bunny",
            "Blender Foundation",
            "10M",
            "10 years ago",
            "https://storage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg",
            "https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        ));
        videoList.add(new Video(
            "Elephant Dream",
            "Blender Foundation",
            "2M",
            "5 years ago",
            "https://storage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg",
            "https://storage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
        ));
        videoList.add(new Video(
            "For Bigger Blazes",
            "Google",
            "1.5M",
            "3 years ago",
            "https://storage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg",
            "https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
        ));
        
        adapter = new VideoAdapter(getContext(), videoList);
        recyclerView.setAdapter(adapter);
        
        return view;
    }
}
