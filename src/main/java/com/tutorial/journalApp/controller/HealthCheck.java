package com.tutorial.journalApp.controller;


import com.tutorial.journalApp.service.WeatherService;
import com.tutorial.journalApp.weatherapi.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/checkWeather/{city}")
    public String checkWeather(@PathVariable String city) {
        WeatherResponse res = weatherService.getWeather(city);

        // Check if the response is null or incomplete to avoid NullPointerException
        if (res == null || res.getCurrent() == null || res.getCurrent().getCondition() == null) {
            return "Unable to fetch weather data for the city: " + city;
        }

        return "Hello! The temperature is " + res.getCurrent().getTemp_c() + "°C and the forecast is: " + res.getCurrent().getCondition().getText();
    }


}
