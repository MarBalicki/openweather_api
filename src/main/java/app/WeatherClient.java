package app;

import app.model.FullWeatherInfo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {
    private static final String API_TOKEN = "";
    private static final HttpClient httpClient = HttpClient.newBuilder().build();

    public String getCityWeatherJson(String city) throws IOException, InterruptedException {
        String basicWeatherUrlTemplate = "https://api.openweathermap.org/data/2.5/weather?q=%s,pl&appid=%s";
        String fullUrl = String.format(basicWeatherUrlTemplate, city, API_TOKEN);

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
        String[] towns = fewTowns.split(", ");
        for (String town : towns) {
            String weather = weatherClient.getCityWeatherJson(town);
//            System.out.println(weather);
            FullWeatherInfo fullWeatherInfo = weatherClient.parseWeatherInfo(weather);
            System.out.println(fullWeatherInfo);
        }

    }

}
