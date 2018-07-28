package com.weather.remote.api;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherServiceBuilder {
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final Converter.Factory CONVERTER_FACTORY = GsonConverterFactory.create();

    public WeatherService build(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(CONVERTER_FACTORY)
                .build();
        return retrofit.create(WeatherService.class);
    }
}
