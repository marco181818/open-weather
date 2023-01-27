package com.finvivir.weather.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

public class PrincipalData implements Serializable {
    private int temp;
    private int feelLike;
    private int tempMin;
    private int tempMax;
    private int pressure;
    private int humidity;
    private int seaLevel;
    private int grndLevel;

    public PrincipalData(){
        super();
    }


    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getFeelLike() {
        return feelLike;
    }

    public int getTempMin() {
        return tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public int getGrndLevel() {
        return grndLevel;
    }

    @JsonProperty("feels_like")
    public void setFeelLike(int feelLike) {
        this.feelLike = feelLike;
    }


    @JsonProperty("temp_min")
    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }


    @JsonProperty("temp_max")
    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    @JsonProperty("sea_level")
    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }


    @JsonProperty("grnd_level")
    public void setGrndLevel(int grndLevel) {
        this.grndLevel = grndLevel;
    }


}
