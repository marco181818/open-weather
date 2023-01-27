package com.finvivir.weather.config;

import com.finvivir.weather.bean.ExceptionBean;
import com.finvivir.weather.exceptions.NotFoundCityException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdviceImpl {


    @ExceptionHandler({ NotFoundCityException.class })
    public ResponseEntity<ExceptionBean> handleNotFoundException(
            Exception ex, WebRequest request) {
        ExceptionBean exceptionBean = new ExceptionBean();
        exceptionBean.setCode(HttpStatus.NOT_FOUND.value());
        exceptionBean.setMessage(ex.getMessage());
        return new ResponseEntity<>( exceptionBean, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ExceptionBean> generalException(
            Exception ex, WebRequest request) {
        ExceptionBean exceptionBean = new ExceptionBean();
        exceptionBean.setCode(HttpStatus.SERVICE_UNAVAILABLE.value());
        exceptionBean.setMessage("Service is temporaly down.");
        return new ResponseEntity<>( exceptionBean, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
