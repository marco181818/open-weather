package com.finvivir.weather.service;

import com.finvivir.weather.bean.Citys;
import com.finvivir.weather.bean.OpenWeather;
import com.finvivir.weather.exceptions.NotFoundCityException;
import com.finvivir.weather.models.Wheater;

import java.util.List;

public interface WeatherService {
    List<Citys> getGeoLocation(String city);
    Wheater getWeather(String city) throws Exception;

    List<Wheater>   getHistory();
}
