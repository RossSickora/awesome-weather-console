package com.weather.handlers;

public class ZeroConsoleExitHandler implements ConsoleExitHandler {
    @Override
    public boolean handle(int code) {
        return code != 0;
    }
}
