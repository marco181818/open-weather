package com.finvivir.weather.bean;

import javax.persistence.*;
import java.io.Serializable;

public class Citys implements Serializable {
    private Integer id;
    private String  name;
    private double  lat;
    private double  lon;

    public  Citys(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
