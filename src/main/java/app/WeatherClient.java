package app;

import app.model.FullWeatherInfo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class WeatherClient {
    private static final String API_TOKEN = "c8d21edcb8d681952c9139e3780454a2";
    private static final HttpClient httpClient = HttpClient.newBuilder().build();

    public String getCityWeatherJson(String city, String country) throws IOException, InterruptedException {
        String basicWeatherUrlTemplate = "https://api.openweathermap.org/data/2.5/weather?q=%s,q=%s&appid=%s";
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


    public static void main(String[] args) throws IOException, InterruptedException {
        WeatherClient weatherClient = new WeatherClient();
        String fewTowns = "Warszawa, Wrocław, Szczecin, Toruń, Iława";
        String poland = "pl";
        String[] towns = fewTowns.split(", ");
        FullWeatherInfo fullWeatherInfo = null;
        Set<FullWeatherInfo> weatherInfoSet = new HashSet<>();
        for (String town : towns) {
            String weather = weatherClient.getCityWeatherJson(town, poland);
            fullWeatherInfo = weatherClient.parseWeatherInfo(weather);
            weatherInfoSet.add(fullWeatherInfo);
        }
        weatherInfoSet.stream()
                .sorted(Comparator.comparing(FullWeatherInfo::getName))
                .forEach(System.out::println);

        String rodos = "Rodos";
        String greece = "gr";
        String weather = weatherClient.getCityWeatherJson(rodos, greece);
        fullWeatherInfo = weatherClient.parseWeatherInfo(weather);
        System.out.println(fullWeatherInfo);



    }

}
