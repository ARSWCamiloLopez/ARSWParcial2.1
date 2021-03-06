/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.persistence.impl;

import edu.eci.arsw.parcial.persistence.ParcialPersistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2105700
 */
@Service
public class InMemoryParcialPersistence implements ParcialPersistence {

    private Map<String, LocalDateTime> cacheTimes = new HashMap<>();
    private Map<String, String> cache = new HashMap<>();

    @Override
    public String getWeatherByCityName(String cityName) throws MalformedURLException, ProtocolException, IOException {

        LocalDateTime now = LocalDateTime.now();
        cacheTimes.put(cityName, now);

        return validateCache(cityName);
    }

    private String validateCache(String cityName) throws ProtocolException, IOException, IOException {
        String toReturn = "";
        for (String x : cacheTimes.keySet()) {
            if (x.equals(cityName)) {
                LocalDateTime now = LocalDateTime.now();
                if (cacheTimes.get(x).isBefore(now)) {
                    toReturn = cache.get(x);
                }
            } else {
                String Url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName
                        + "&appid=d6a8f9e598220b8c50c9f2ad6f670a0e";
                cache.put(cityName, getHttpRequest(Url));
                toReturn = getHttpRequest(Url);
            }
        }
        return toReturn;
    }

    private String getHttpRequest(String GET_URL) throws MalformedURLException, ProtocolException, IOException {

        String USER_AGENT = "Mozilla/5.0";

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            return "GET request not worked";
        }
    }
}
