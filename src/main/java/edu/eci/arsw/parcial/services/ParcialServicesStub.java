/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.services;

import edu.eci.arsw.parcial.persistence.ParcialPersistence;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2105700
 */
@Service
public class ParcialServicesStub implements ParcialServices{
    
    @Autowired
    ParcialPersistence pPersistence;

    @Override
    public String getWeatherByCityName(String cityName) throws MalformedURLException, ProtocolException, IOException{
        return pPersistence.getWeatherByCityName(cityName);
    }
    
}
