package com.finvivir.weather.bean;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private int lon;
    private int lat;


    public Coordinates(){
        super();
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

}
