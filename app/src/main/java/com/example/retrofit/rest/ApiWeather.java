package com.example.retrofit.rest;

import com.example.retrofit.rest.entities.MainWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiWeather {

//    q=almaty&units=metric&APPID=6bab4d6713adbf3a428b1f2a7454395d

    @GET(Config.PATH_FOR_DATA + "weather")
    Call<MainWeather> getWeather(
            @Query("q") String city,
            @Query("units") String units,
            @Query("APPID") String appID);

}
