package app.controller;

import app.model.FullWeatherInfo;
import app.service.WeatherClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherClient weatherClient;

    public WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("/weather/{city}")
    public FullWeatherInfo getWeather(@PathVariable String city) throws IOException, InterruptedException {
        return weatherClient.getWeatherFromOutsideApi(city, "pl");
    }


}
