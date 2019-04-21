package com.example.retrofit.rest.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainWeather {
    @Expose
    @SerializedName("weather")
    private List<Weather> weatherList;

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public MainWeather(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}
