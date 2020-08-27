package app.service;

import app.model.FullWeatherInfo;
import app.repository.WeatherRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

@Service
public class WeatherClient {
    private static final String API_TOKEN = "c8d21edcb8d681952c9139e3780454a2";
    private static final HttpClient httpClient = HttpClient.newBuilder().build();

    private final WeatherRepository weatherRepository;

    public WeatherClient(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public FullWeatherInfo getWeatherFromOutsideApi(String city, String country) throws IOException, InterruptedException {
        String weatherJson = getCityWeatherJson(city, country);
        FullWeatherInfo fullWeatherInfo = parseWeatherInfo(weatherJson);
        fullWeatherInfo.setDate(new Date());
        return weatherRepository.save(fullWeatherInfo);
    }

    public void save(FullWeatherInfo fullWeatherInfo) {
        weatherRepository.save(fullWeatherInfo);
    }

    public String getCityWeatherJson(String city, String country) throws IOException, InterruptedException {
        String basicWeatherUrlTemplate = "https://api.openweathermap.org/data/2.5/weather?q=%s,q=%s&units=metric&appid=%s";
        String fullUrl = String.format(basicWeatherUrlTemplate, city, country, API_TOKEN);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(fullUrl))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("Status CODE: " + response.statusCode());
        return response.body();
    }

    private FullWeatherInfo parseWeatherInfo(String weatherJson) {
        Gson gson = new Gson();
        return gson.fromJson(weatherJson, FullWeatherInfo.class);
    }

}
