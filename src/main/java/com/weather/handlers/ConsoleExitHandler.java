package com.weather.handlers;

public class ConsoleExitHandler implements ExitHandler {
    @Override
    public boolean handle(int code) {
        return code != 0;
    }
}
