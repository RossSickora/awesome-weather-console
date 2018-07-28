package com.weather.console;

import com.weather.handlers.ConsoleExitHandler;
import com.weather.handlers.ExitHandler;
import com.weather.models.WeatherResponse;
import com.weather.presentation.ConsolePresentationAdapter;
import com.weather.presentation.FahrenheitPresentationAdapter;
import com.weather.remote.api.WeatherRepository;
import com.weather.remote.api.WeatherServiceBuilder;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String args[]){
        WeatherRepository weatherRepository = new WeatherRepository(new WeatherServiceBuilder().build());
        ConsolePresentationAdapter presentationAdapter = new FahrenheitPresentationAdapter();
        ExitHandler exitHandler = new ConsoleExitHandler();
        boolean runTilFalse = true;
        Scanner inputScanner = new Scanner(System.in);
        while(runTilFalse){
            System.out.println(presentationAdapter.retrieveWelcomeMessage());
            String cityName = inputScanner.next();
            WeatherResponse response = weatherRepository.getWeatherFor(cityName);

            System.out.println(presentationAdapter.retrieveCityWeatherLabel(cityName));
            System.out.println(presentationAdapter.adaptWeatherResponseForTemperatureOnly(response));

            System.out.println(presentationAdapter.retrieveExitPrompt());
            int nextCode = inputScanner.nextInt();
            runTilFalse = exitHandler.handle(nextCode);

        }

    }
}