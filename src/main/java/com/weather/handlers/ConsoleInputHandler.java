package com.weather.handlers;

public class ConsoleInputHandler {
    private static final String LETTERS_ONLY_REGEX = "[A-Za-z ]*";

    public boolean isLettersOnly(String inputString) {
        boolean outcome = false;
        if(inputString != null){
            outcome = inputString.matches(LETTERS_ONLY_REGEX);
        }
        return outcome;
    }
}
