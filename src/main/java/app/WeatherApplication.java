package app;

import app.model.*;
import app.service.WeatherClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WeatherApplication {

    private static WeatherClient weatherClient;

    public WeatherApplication(WeatherClient weatherClient) {
        WeatherApplication.weatherClient = weatherClient;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(WeatherApplication.class, args);
        System.out.println("Działam");
//        for (int i = 0; i < 1000000; i++) {
//            weatherClient.getWeatherFromOutsideApi("Iława", "pl");
//            weatherClient.getWeatherFromOutsideApi("Nesebyr", "bg");
//            Thread.sleep(300000);
//        }
//        FullWeatherInfo weatherFromOutsideApi = weatherClient.getWeatherFromOutsideApi("Wrocław", "pl");
//        System.out.println(weatherFromOutsideApi);

    }
}
