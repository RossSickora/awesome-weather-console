package com.weather.remote.api;

import com.weather.models.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("weather")
    Call<WeatherResponse> getWeatherFor(@Query("q") String city, @Query("APPID") String appId, @Query("units") String units);
}
