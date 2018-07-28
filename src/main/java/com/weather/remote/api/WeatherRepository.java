package com.weather.remote.api;

import com.weather.models.WeatherResponse;
import retrofit2.Response;

import java.io.IOException;

public class WeatherRepository {
    WeatherService service;


    public WeatherRepository(WeatherService service){
        this.service = service;
    }
    protected static final String APPID = "2fe43513a88bca72e6393f3259378672";
    protected static final String UNITS = "imperial";
    public WeatherResponse getWeatherFor(String city){
        Response<WeatherResponse> response = null;
        try {
            response  = service.getWeatherFor(city, APPID, UNITS).execute();
        } catch (IOException e) {
            //doNothingForNow
            //e.printStackTrace();
        }
        if(response == null){
            return null;
        }
        else{
            return response.body();
        }
    }
}
