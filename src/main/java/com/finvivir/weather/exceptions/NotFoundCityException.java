package com.finvivir.weather.exceptions;

public class NotFoundCityException extends Exception{

    public NotFoundCityException() {
    }

    public NotFoundCityException(String message) {
        super(message);
    }
}
