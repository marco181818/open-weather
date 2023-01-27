package com.finvivir.weather.bean;

import java.io.Serializable;

public class Wind implements Serializable {
    private Integer windId;
    private int speed;
    private int deg;
    private int gust;

    public Wind(){
        super();
    }

    public Integer getWindId() {
        return windId;
    }

    public void setWindId(Integer windId) {
        this.windId = windId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getGust() {
        return gust;
    }

    public void setGust(int gust) {
        this.gust = gust;
    }
}
