package com.weather.presentation;

import com.weather.models.WeatherResponse;

public interface ConsolePresentationAdapter {
    String retrieveWelcomeMessage();
    String retrieveCityWeatherLabel(String city);
    String adaptWeatherResponseForTemperatureOnly(WeatherResponse response);
    String retrieveExitPrompt();
}
