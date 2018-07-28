package com.weather.presentation;

import com.weather.models.WeatherResponse;

public interface ConsolePresentationAdapter {
    String getTemperature(WeatherResponse response);
}
