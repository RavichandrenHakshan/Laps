package com.example.laps;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laps.api.ApiClient;
import com.example.laps.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        adapter = new VideoAdapter(getContext(), videoList);
        recyclerView.setAdapter(adapter);
        
        fetchVideos();
        
        return view;
    }

    private void fetchVideos() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Video>> call = apiService.getVideos();

        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    videoList.clear();
                    videoList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    if (getContext() != null) {
                        Toast.makeText(getContext(), "Failed to load videos", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("HomeFragment", "API Error: " + t.getMessage());
                if (getContext() != null) {
                    Toast.makeText(getContext(), "Network error. Make sure WAMP is running.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
