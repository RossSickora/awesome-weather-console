package com.weather;

import com.weather.presentation.PresentationAdapter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PresentationAdapterTest {
    PresentationAdapter classUnderTest = new PresentationAdapter();
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void retrieveWelcomeMessage_prompts_for_input(){
        String expectedWelcomeMessage = "Where are you?";
        Assert.assertTrue(expectedWelcomeMessage.equalsIgnoreCase(classUnderTest.retrieveWelcomeMessage()));
    }
}