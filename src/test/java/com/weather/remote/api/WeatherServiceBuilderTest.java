package com.weather.remote.api;

import org.junit.Before;
import org.junit.Test;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WeatherServiceBuilderTest {
    WeatherServiceBuilder classUnderTest;

    @Before
    public void setUp(){
        classUnderTest = new WeatherServiceBuilder();
    }

    @Test
    public void builderHasJSONPlaceHolderServiceBaseURL() {
        String expectedURL = "https://api.openweathermap.org/data/2.5/";
        assertTrue(expectedURL.equalsIgnoreCase(classUnderTest.BASE_URL));
    }

    @Test
    public void builderHasGsonConverterFactoryToAddToService(){
        assertNotNull(classUnderTest.CONVERTER_FACTORY);
        assertTrue(classUnderTest.CONVERTER_FACTORY instanceof GsonConverterFactory);
    }
}
