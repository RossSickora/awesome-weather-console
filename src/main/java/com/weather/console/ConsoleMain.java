package com.weather.console;

import com.weather.handlers.ZeroConsoleExitHandler;
import com.weather.handlers.ConsoleExitHandler;
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
        ConsoleExitHandler consoleExitHandler = new ZeroConsoleExitHandler();
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
            runTilFalse = consoleExitHandler.handle(nextCode);

        }

    }
}