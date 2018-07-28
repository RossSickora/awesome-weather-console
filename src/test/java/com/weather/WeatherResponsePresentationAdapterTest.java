package com.weather;

import com.weather.models.Main;
import com.weather.models.WeatherResponse;
import com.weather.presentation.WeatherResponsePresentationAdapter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WeatherResponsePresentationAdapterTest {
    WeatherResponsePresentationAdapter classUnderTest = new WeatherResponsePresentationAdapter();
    private double temp = 75.0;
    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void adaptWeatherResponseForTemperatureOnly_provides_presentable_temperature(){
        WeatherResponse response = getResponse();
        String expectedTempValue = temp + " Fahrenheit";
        assertTrue(expectedTempValue.equalsIgnoreCase(classUnderTest.getTemperature(response)));
    }

    @Test
    public void adaptWeatherResponseForTemperatureOnly_provides_presentable_temperature_when_no_temp(){
        WeatherResponse response = getNoTempResponse();
        String expectedTempValue = "Unavailable";
        assertTrue(expectedTempValue.equalsIgnoreCase(classUnderTest.getTemperature(response)));
    }

    @Test
    public void adaptWeatherResponseForTemperatureOnly_provides_presentable_temperature_when_no_main(){
        WeatherResponse response = getNoMainResponse();
        String expectedTempValue = "Unavailable";
        assertTrue(expectedTempValue.equalsIgnoreCase(classUnderTest.getTemperature(response)));
    }


    private WeatherResponse getResponse() {
        WeatherResponse response = new WeatherResponse();
        Main main = new Main();
        main.setTemp(temp);
        response.setMain(main);
        return response;
    }

    private WeatherResponse getNoTempResponse(){
        WeatherResponse response = new WeatherResponse();
        Main main = new Main();
        response.setMain(main);
        return response;
    }

    private WeatherResponse getNoMainResponse(){
        WeatherResponse response = new WeatherResponse();
        return response;
    }
}