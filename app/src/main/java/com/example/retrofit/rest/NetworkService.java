package com.example.retrofit.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mService = null;
    private Retrofit mRetrofit;

    public static NetworkService getInstance(){
        if(mService == null){
            mService = new NetworkService();
        }
        return mService;
    }

    private NetworkService(){
        OkHttpClient okHttp = new OkHttpClient.Builder()
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp)
                .build();
    }

    public ApiWeather getApiWeather(){
        return mRetrofit.create(ApiWeather.class);
    }
}
