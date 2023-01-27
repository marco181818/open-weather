package com.finvivir.weather.controller;

import com.finvivir.weather.bean.Citys;
import com.finvivir.weather.bean.ExceptionBean;
import com.finvivir.weather.bean.OpenWeather;
import com.finvivir.weather.exceptions.NotFoundCityException;
import com.finvivir.weather.models.Wheater;
import com.finvivir.weather.service.WeatherService;
import com.finvivir.weather.service.impl.WeatherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    Logger logger = LoggerFactory.getLogger(WeatherController.class);

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @Operation(summary = "Consulta la latitud y longitud de una ciudad.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found data",  content = { @Content(mediaType = "application/json",    schema = @Schema(implementation = Citys[].class)) })})

    @GetMapping(value = "/geo-position")
    public ResponseEntity<List<Citys>>    getGeoPosition(@Parameter(description = "Nombre de la ciudad a consultar el clima.", example = "cdmx")  @RequestParam String city){

        List<Citys> response = weatherService.getGeoLocation(city);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Consulta información del clima de una ciudad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informacion del clima.",  content = { @Content(mediaType = "application/json",    schema = @Schema(implementation = Wheater.class)) }),
            @ApiResponse(responseCode = "404", description = "Ciudad no encontrada",  content = { @Content(mediaType = "application/json",    schema = @Schema(implementation = ExceptionBean.class)) }),
            @ApiResponse(responseCode = "503", description = "Servicio temporalmente abajo",  content = { @Content(mediaType = "application/json",    schema = @Schema(implementation = ExceptionBean.class)) })})

    @GetMapping(value = "/getWeather")
    @ResponseBody
    public  ResponseEntity<Wheater>  getWeather(@RequestParam String city) throws Exception {
        logger.info("Ciudad a consulta el clima: {}.",city);
        Wheater response = weatherService.getWeather(city);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Consulta información de las ultimas 10 ciudades obtenidas exitosas")
    @ApiResponses( value = { @ApiResponse( content = { @Content( mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Wheater.class))) }) })
    @GetMapping(value = "/getHistory")
    @ResponseBody
    public  ResponseEntity<List<Wheater>> getHistory(){
        logger.info("Listando movimientos historicos.");
        return new ResponseEntity<>(weatherService.getHistory(), HttpStatus.OK);
    }

}
