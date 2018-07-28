package com.weather.presentation;

import com.weather.models.WeatherResponse;

public class PresentationAdapter {
    private static final String WELCOME_MESSAGE = "Where are you?";

    public String retrieveWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public String retrieveCityWeatherLabel(String city) {
        return city.concat(" weather:");
    }

    public String adaptWeatherResponseForTemperatureOnly(WeatherResponse response){
        return String.valueOf(response.getMain().getTemp()).concat(" Fahrenheit");
    }
}
