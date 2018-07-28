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
        WeatherResponse weatherResponse;
        Response<WeatherResponse> response = null;
        try {
            response  = service.getWeatherFor(city, APPID, UNITS).execute();
        } catch (IOException e) {
            //weatherResponse = new WeatherResponse(); -- Handled by response check below
        }
        if(response == null || !response.isSuccessful()){
            weatherResponse = new WeatherResponse();
        } else{
            weatherResponse = response.body();
        }
        return weatherResponse;
    }
}
