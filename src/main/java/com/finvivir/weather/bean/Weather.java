package com.finvivir.weather.bean;

import java.io.Serializable;

public class Weather implements Serializable {
    private String main;
    private String description;

    public  Weather(){
        super();
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

