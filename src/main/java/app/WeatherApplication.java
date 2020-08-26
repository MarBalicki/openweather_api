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
//            weatherClient.getWeatherFromOutsideApi("Wrocław", "pl");
//            weatherClient.getWeatherFromOutsideApi("Iława", "pl");
//            weatherClient.getWeatherFromOutsideApi("Nesebyr", "bg");
//            Thread.sleep(300000);
//        }


//        FullWeatherInfo fullWeatherInfo = new FullWeatherInfo(100L, "Toruń", new CloudsWeatherInfo(100),
//                new MainWeatherInfo(23.1, 21.9, 1010, 69), new WindWeatherInfo(2.1), 100);
////        weatherClient.save(fullWeatherInfo);
//        FullWeatherInfo fullWeatherInfo1 = weatherClient.getWeatherFromOutsideApi("Wrocław");
//        weatherClient.save(fullWeatherInfo1);
////        System.out.println(fullWeatherInfo);
//        System.out.println(fullWeatherInfo1);

    }
}
