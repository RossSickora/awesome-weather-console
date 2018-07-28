package com.weather.handlers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleExitHandlerTest {
    ConsoleExitHandler classUnderTest;
    @Before
    public void setUp() throws Exception {
        classUnderTest = new ConsoleExitHandler();
    }

    @Test
    public void handle_returns_false_when_provided_zero(){
        int providedInput = 0;
        boolean expected = false;

        assertEquals(expected, classUnderTest.handle(providedInput));

    }

    @Test
    public void handle_returns_true_when_provided_greater_than_zero(){
        int providedInput = 1;
        boolean expected = true;

        assertEquals(expected, classUnderTest.handle(providedInput));
    }

    @Test
    public void handle_returns_true_when_provided_less_than_zero(){
        int providedInput = -1;
        boolean expected = true;

        assertEquals(expected, classUnderTest.handle(providedInput));
    }
}