package com.tutorial.journalApp.service;

import com.tutorial.journalApp.weatherapi.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class WeatherService{
    // api key 3e7c724d3c44410497095940240507
    //private static final String API_key = "ae9186a87a204cbe9c394656252101";
    //private static final String BASE_URL = "http://api.weatherapi.com/v1/current.json?key=API_KEY&q=CITY&aqi=no";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.base-url}")
    private String baseUrl;

    public WeatherResponse getWeather(String city) {
        try {
            String finalURL = String.format("%s?key=%s&q=%s&aqi=no", baseUrl, apiKey, city);
            System.out.println("Calling URL: " + finalURL); // Debug log
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(
                    finalURL, HttpMethod.GET, null, WeatherResponse.class
            );
            System.out.println("Response received: " + response.getBody()); // Debug log
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Error while calling Weather API: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
