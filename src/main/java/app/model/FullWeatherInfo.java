package app.model;

public class FullWeatherInfo {

    private String name;
    private CloudsWeatherInfo clouds;
    private WeatherInfo[] weather;
    private MainWeatherInfo main;
    private WindWeatherInfo wind;
    private int visibility;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClouds(CloudsWeatherInfo clouds) {
        this.clouds = clouds;
    }

    public void setWeather(WeatherInfo[] weather) {
        this.weather = weather;
    }

    public void setMain(MainWeatherInfo main) {
        this.main = main;
    }

    public void setWind(WindWeatherInfo wind) {
        this.wind = wind;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "FullWeatherInfo{" +
                "City name " + name +
                ", clouds " + clouds +
                ", " + weather[0] +
                ", main " + main +
                ", wind " + wind +
                ", visibility " + visibility +
                '}';
    }
}
