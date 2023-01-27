package com.finvivir.weather.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wheater")
public class Wheater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer weatherId;
    @Column
    private String searchCity;
    @Column
    private int timeZone;
    @Column
    private String city;
    @Column
    private int longitude;
    @Column
    private int latitude;
    @Column
    private int windSpeed;
    @Column
    private int windDeg;
    @Column
    private int windGust;
    @Column
    private String weatherMain;
    @Column
    private String weatherDesc;
    @Column
    private int temperature;
    @Column
    private int pressure;
    @Column
    private int humidity;
    @Column
    private int temperatureFeelsLike;
    @Column
    private int minTemperature;
    @Column
    private int maxTemperature;
    @Column
    private int seaLevel;
    @Column
    private Date createdAt;
    @Column
    private Date lastUpdate;

    public Wheater(){
        super();
    }

    public Integer getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(Integer weatherId) {
        this.weatherId = weatherId;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }

    public int getWindGust() {
        return windGust;
    }

    public void setWindGust(int windGust) {
        this.windGust = windGust;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
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

    public int getTemperatureFeelsLike() {
        return temperatureFeelsLike;
    }

    public void setTemperatureFeelsLike(int temperatureFeelsLike) {
        this.temperatureFeelsLike = temperatureFeelsLike;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSearchCity() {
        return searchCity;
    }

    public void setSearchCity(String searchCity) {
        this.searchCity = searchCity;
    }

    @PrePersist
    public void onCreate(){
        createdAt = new Date();
        lastUpdate = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        lastUpdate = new Date();
    }

}
