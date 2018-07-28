package com.weather.remote.api;

import com.weather.models.WeatherResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class WeatherRepositoryTest {

    WeatherRepository classUnderTest;

    @Mock
    private WeatherService serviceMock;
    @Mock
    private Call<WeatherResponse> callMock;
    private static final String city = "Chicago";


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(serviceMock.getWeatherFor(city, classUnderTest.APPID, classUnderTest.UNITS)).thenReturn(callMock);
        classUnderTest = new WeatherRepository(serviceMock);
    }

    @Test
    public void retrieveDoesNothingWhenExceptionThrownByService() throws IOException {
        Mockito.when(callMock.execute()).thenThrow(new IOException("Oh No, bad IO"));
        WeatherResponse response = classUnderTest.getWeatherFor(city);

        assertNotNull(response);
        assertNull(response.getMain());
    }

    @Test
    public void retrieveReturnsAPIResponseBodyWhenCallSuccessful() throws IOException {
        WeatherResponse expectedModel = getValidModel();
        Response<WeatherResponse> expected = Mockito.mock(Response.class);
        Mockito.when(expected.isSuccessful()).thenReturn(true);
        Mockito.when(expected.body()).thenReturn(expectedModel);
        Mockito.when(callMock.execute()).thenReturn(expected);

        WeatherResponse weatherResponse = classUnderTest.getWeatherFor(city);
        assertNotNull(weatherResponse);
        assertEquals(expectedModel, weatherResponse);
    }

    @Test
    public void retrieveReturnsEmptyAPIRsponseWhenCallIsNotSuccessful() throws IOException {
        WeatherResponse expectedModel = getValidModel();
        Response<WeatherResponse> expected = Mockito.mock(Response.class);
        Mockito.when(expected.isSuccessful()).thenReturn(false);
        Mockito.when(expected.body()).thenReturn(expectedModel);
        Mockito.when(callMock.execute()).thenReturn(expected);

        WeatherResponse weatherResponse = classUnderTest.getWeatherFor(city);
        assertNotNull(weatherResponse);
        assertNull(weatherResponse.getMain());
    }

    private WeatherResponse getValidModel() {
        WeatherResponse model = new WeatherResponse();
        return model;
    }
}
