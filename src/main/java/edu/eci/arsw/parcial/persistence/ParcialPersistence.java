/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.persistence;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

/**
 *
 * @author 2105700
 */
public interface ParcialPersistence {
    
    /**
     *
     * @param cityName
     * @return
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public String getWeatherByCityName(String cityName) throws MalformedURLException, ProtocolException, IOException;
    
}
