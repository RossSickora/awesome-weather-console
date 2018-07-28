package com.weather.handlers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleInputHandlerTest {
    ConsoleInputHandler classUnderTest;
    @Before
    public void setUp() throws Exception {
        classUnderTest  = new ConsoleInputHandler();
    }

    @Test
    public void isLettersOnly_pass_for_letter_only_string(){
        String inputString = "Chicago";
        assertTrue(classUnderTest.isLettersOnly(inputString));
    }
    @Test
    public void isLettersOnly_fails_for_string_with_number(){
        String inputString = "Ch1cago";
        assertTrue(classUnderTest.isLettersOnly(inputString) == false);
    }

    @Test
    public void isLettersOnly_fails_for_string_with_special_character(){
        String inputString = "Ch*cago";
        assertTrue(classUnderTest.isLettersOnly(inputString) == false);
    }

    @Test
    public void isLettersOnly_fails_for_string_with_punctuation(){
        String inputString = "Ch?cago";
        assertTrue(classUnderTest.isLettersOnly(inputString) == false);
    }

    @Test
    public void isLettersOnly_fails_for_null_string(){
        String inputString = null;
        assertTrue(classUnderTest.isLettersOnly(inputString) == false);
    }
}