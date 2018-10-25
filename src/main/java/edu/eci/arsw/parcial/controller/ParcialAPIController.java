/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.controller;

import edu.eci.arsw.parcial.services.ParcialServices;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2105700
 */
@RestController
@RequestMapping(value = "/weather")
public class ParcialAPIController {

    @Autowired
    ParcialServices pServices;

    /**
     *
     * @param cityName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{cityName}")
    public ResponseEntity<?> getWeatherByCityName(@PathVariable("cityName") String cityName) {
        try {
            return new ResponseEntity<>(pServices.getWeatherByCityName(cityName),
                    HttpStatus.ACCEPTED);
        } catch (IOException ex) {
            return new ResponseEntity<>("No se han podido obtener las acciones", HttpStatus.NOT_FOUND);
        }
    }

}
