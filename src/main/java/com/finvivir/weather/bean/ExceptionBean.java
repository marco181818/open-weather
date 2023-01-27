package com.finvivir.weather.bean;

import java.io.Serializable;

public class ExceptionBean implements Serializable {
    private int code;
    private String message;

    public ExceptionBean(){
        super();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
