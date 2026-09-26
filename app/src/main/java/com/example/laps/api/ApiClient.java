package com.example.laps.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // Note: Use "10.0.2.2" to access localhost (WAMP) from the Android emulator.
    // If you are using a physical device, use your computer's local IP address (e.g., "192.168.1.X").
    private static final String BASE_URL = "http://10.0.2.2/"; 
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
