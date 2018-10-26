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
     * Esta clase retorna el String que genera el API al cual se hace el llamado
     * dependiendo de el nombre de la ciudad
     *
     * @param cityName El nombre de la ciudad
     * @return El Json que retorna el API
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public String getWeatherByCityName(String cityName) throws MalformedURLException, ProtocolException, IOException;

}
