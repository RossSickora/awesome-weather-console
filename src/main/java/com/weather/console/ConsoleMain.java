package com.weather.console;

import com.weather.handlers.ConsoleInputHandler;
import com.weather.handlers.ZeroConsoleExitHandler;
import com.weather.handlers.ConsoleExitHandler;
import com.weather.models.WeatherResponse;
import com.weather.presentation.ConsolePresentationAdapter;
import com.weather.presentation.WeatherResponsePresentationAdapter;
import com.weather.remote.api.WeatherRepository;
import com.weather.remote.api.WeatherServiceBuilder;

import java.util.Scanner;

public class ConsoleMain {
    private static final String WELCOME_MESSAGE = "Where are you?";
    private static final String EXIT_REQUEST = "Enter 0 to exit";

    public static void main(String args[]){
        WeatherRepository weatherRepository = new WeatherRepository(new WeatherServiceBuilder().build());
        ConsolePresentationAdapter presentationAdapter = new WeatherResponsePresentationAdapter();
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        ConsoleExitHandler consoleExitHandler = new ZeroConsoleExitHandler();
        boolean runTilFalse = true;
        Scanner inputScanner = new Scanner(System.in);
        while(runTilFalse){
            System.out.println(WELCOME_MESSAGE);
            String cityName = inputScanner.nextLine();
            if(inputHandler.isLettersOnly(cityName)){
                WeatherResponse response = weatherRepository.getWeatherFor(cityName);
                System.out.println(cityName.concat(" weather:"));
                System.out.println(presentationAdapter.getTemperature(response));
            } else {
                System.out.println("City names can only contain letters, Let's try again!");
                continue;
            }

            System.out.println(EXIT_REQUEST);
            int nextCode = inputScanner.nextInt();
            runTilFalse = consoleExitHandler.handle(nextCode);

    }

    }
}