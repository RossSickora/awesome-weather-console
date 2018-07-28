package com.weather.presentation;

import com.weather.models.WeatherResponse;

public class WeatherResponsePresentationAdapter implements ConsolePresentationAdapter {

    @Override
    public String getTemperature(WeatherResponse response){
        String responseString;
        if(response == null || response.getMain() == null || response.getMain().getTemp() == null){
            responseString = "Unavailable";
        }
        else {
            responseString = String.valueOf(response.getMain().getTemp()).concat(" Fahrenheit");
        }
        return responseString;
    }
}
