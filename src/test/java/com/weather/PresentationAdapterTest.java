package com.weather;

import com.weather.models.Main;
import com.weather.models.WeatherResponse;
import com.weather.presentation.PresentationAdapter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PresentationAdapterTest {
    PresentationAdapter classUnderTest = new PresentationAdapter();
    private double temp = 75.0;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void retrieveWelcomeMessage_prompts_for_input(){
        String expectedWelcomeMessage = "Where are you?";
        assertTrue(expectedWelcomeMessage.equalsIgnoreCase(classUnderTest.retrieveWelcomeMessage()));
    }

    @Test
    public void retrieveCityWeatherLabelTest(){
        String city = "Chicago";
        String expectedWeatherLabel = "Chicago weather:";
        assertTrue(expectedWeatherLabel.equalsIgnoreCase(classUnderTest.retrieveCityWeatherLabel(city)));
    }

    @Test
    public void adaptWeatherResponseForTemperatureOnly_provides_presentable_temperature(){
        WeatherResponse response = getResponse();
        String expectedTempValue = temp + " Fahrenheit";
        assertTrue(expectedTempValue.equalsIgnoreCase(classUnderTest.adaptWeatherResponseForTemperatureOnly(response)));
    }

    private WeatherResponse getResponse() {
        WeatherResponse response = new WeatherResponse();
        Main main = new Main();
        main.setTemp(temp);
        response.setMain(main);
        return response;
    }
}