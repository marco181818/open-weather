package com.finvivir.weather.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class OpenWeather implements Serializable {

    private int timezone;
    private String name;
    private List<Weather> weather;
    private Coordinates coord;
    private PrincipalData main;
    private Wind wind;

    public  OpenWeather(){
        super();
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public PrincipalData getMain() {
        return main;
    }

    public void setMain(PrincipalData main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
