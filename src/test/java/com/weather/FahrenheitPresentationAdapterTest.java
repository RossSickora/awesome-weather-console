package com.weather;

import com.weather.models.Main;
import com.weather.models.WeatherResponse;
import com.weather.presentation.FahrenheitPresentationAdapter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FahrenheitPresentationAdapterTest {
    FahrenheitPresentationAdapter classUnderTest = new FahrenheitPresentationAdapter();
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

    @Test
    public void retrieveExitPrompt_prompts_zero_to_exit(){
        String expected = "Enter 0 to exit";
        assertTrue(expected.equalsIgnoreCase(classUnderTest.retrieveExitPrompt()));
    }

    private WeatherResponse getResponse() {
        WeatherResponse response = new WeatherResponse();
        Main main = new Main();
        main.setTemp(temp);
        response.setMain(main);
        return response;
    }
}