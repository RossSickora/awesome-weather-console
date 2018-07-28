package com.weather.presentation;

import com.weather.models.WeatherResponse;

public class FahrenheitPresentationAdapter implements ConsolePresentationAdapter {
    private static final String WELCOME_MESSAGE = "Where are you?";

    @Override
    public String retrieveWelcomeMessage() {
        return WELCOME_MESSAGE;
    }
    @Override
    public String retrieveCityWeatherLabel(String city) {
        return city.concat(" weather:");
    }
    @Override
    public String adaptWeatherResponseForTemperatureOnly(WeatherResponse response){
        return String.valueOf(response.getMain().getTemp()).concat(" Fahrenheit");
    }
    @Override
    public String retrieveExitPrompt(){
        return "Enter 0 to exit";
    }
}
