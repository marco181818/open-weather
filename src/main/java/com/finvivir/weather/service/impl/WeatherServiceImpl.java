package com.finvivir.weather.service.impl;

import com.finvivir.weather.bean.Citys;
import com.finvivir.weather.bean.OpenWeather;
import com.finvivir.weather.exceptions.NotFoundCityException;
import com.finvivir.weather.models.Wheater;
import com.finvivir.weather.repository.WheaterRepository;
import com.finvivir.weather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class WeatherServiceImpl implements WeatherService {

    Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Value("${api.weather.paths.getGeoPosition}")
    private String  geoPosition;

    @Value("${api.weather.paths.getWeather}")
    private String  weatherPath;

    private RestTemplate restTemplate;

    private WheaterRepository wheaterRepository;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate, WheaterRepository wheaterRepository){
        this.restTemplate = restTemplate;
        this.wheaterRepository = wheaterRepository;
    }

    @Override
    public List<Citys> getGeoLocation(String city) {
        System.out.println(geoPosition);

        List<Citys> response = Arrays.asList(restTemplate.getForEntity(geoPosition, Citys[].class, city).getBody());

        System.out.println(response);
        return response;
    }

    @Override
    public Wheater getWeather(String city) throws Exception {

        Wheater wheater = new Wheater();
        List<Citys> citys;
        try{
            logger.info("Obteniendo geolocalizacion de la ciudad:{}.", city);
            citys = Arrays.asList(restTemplate.getForEntity(geoPosition, Citys[].class, city).getBody());
        }catch (Exception e){
            logger.error("Servicio de OpenWeather caido.");
            citys = Collections.emptyList();
        }

        if(citys.isEmpty()){
            dataOfCache(city);
        }

        logger.info("Obteniendo informacion del clima de la ciudad:{}.",city);
        OpenWeather response = restTemplate.getForEntity(weatherPath, OpenWeather.class, citys.get(0).getLat(), citys.get(0).getLon()).getBody();

        wheater.setTimeZone(response.getTimezone());
        wheater.setCity(response.getName());
        wheater.setSearchCity(city);

        if(response.getCoord()!=null){
            wheater.setLatitude(response.getCoord().getLat());
            wheater.setLongitude(response.getCoord().getLon());
        }

        if(response.getMain() != null){
            wheater.setTemperature(response.getMain().getTemp());
            wheater.setPressure(response.getMain().getPressure());
            wheater.setHumidity(response.getMain().getHumidity());
            wheater.setTemperatureFeelsLike(response.getMain().getFeelLike());
            wheater.setMaxTemperature(response.getMain().getTempMax());
            wheater.setMinTemperature(response.getMain().getTempMin());
            wheater.setSeaLevel(response.getMain().getSeaLevel());
        }

        if(!response.getWeather().isEmpty()){
            wheater.setWeatherMain(response.getWeather().get(0).getMain());
            wheater.setWeatherDesc(response.getWeather().get(0).getDescription());
        }

        if(response.getWind() != null){
            wheater.setWindSpeed(response.getWind().getSpeed());
            wheater.setWindDeg(response.getWind().getDeg());
            wheater.setWindGust(response.getWind().getGust());
        }

        wheaterRepository.save(wheater);

        return wheater;
    }

    private Wheater dataOfCache(String city) throws NotFoundCityException {
        logger.info("Buscando informacion de la ciudad {} en BD.", city);
        Optional<Wheater> wheater = wheaterRepository.serviceDown(city);

        if(!wheater.isPresent()){
            throw new NotFoundCityException("City "+city+" Not Found");
        }

        return wheater.get();
    }

    @Override
    public List<Wheater> getHistory() {
        Pageable pageable = PageRequest.of(0,10, Sort.by("weatherId").descending());

        return wheaterRepository.findAllBy(pageable);

    }
}
