package com.weather.console;

import com.weather.models.WeatherResponse;
import com.weather.remote.api.WeatherRepository;
import com.weather.remote.api.WeatherServiceBuilder;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String args[]){
        WeatherRepository weatherRepository = new WeatherRepository(new WeatherServiceBuilder().build());
        boolean runTilFalse = true;
        Scanner inputScanner = new Scanner(System.in);
        while(runTilFalse){
            System.out.println("Where are you?");
            String cityName = inputScanner.next();
            WeatherResponse response = weatherRepository.getWeatherFor(cityName);

            System.out.println(cityName + " " + "weather:");
            System.out.println(response.getMain().getTemp() + " Farenheit");

            System.out.println("Enter 0 to exit");
            int nextCode = inputScanner.nextInt();
            if(nextCode == 0){
                runTilFalse = false;
            }
        }

    }
}