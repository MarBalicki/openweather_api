package app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "weather_info")
public class FullWeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name")
    private String name;
    @Embedded
    private CloudsWeatherInfo clouds;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_info_id", nullable = false, updatable = false)
    private List<WeatherInfo> weather;
    @Embedded
    private MainWeatherInfo main;
    @Embedded
    private WindWeatherInfo wind;
    private int visibility;
    @Embedded
    private CoordinatesWeatherInfo coord;
    private Date date;

    public FullWeatherInfo(String name) {
        this.name = name;
    }

    public List<WeatherInfo> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherInfo> weather) {
        this.weather = weather;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClouds(CloudsWeatherInfo clouds) {
        this.clouds = clouds;
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

    public Long getId() {
        return id;
    }

    public CloudsWeatherInfo getClouds() {
        return clouds;
    }

    public MainWeatherInfo getMain() {
        return main;
    }

    public WindWeatherInfo getWind() {
        return wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public CoordinatesWeatherInfo getCoord() {
        return coord;
    }

    public void setCoord(CoordinatesWeatherInfo coord) {
        this.coord = coord;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public FullWeatherInfo() {
    }

    public FullWeatherInfo(Long id, String name, CloudsWeatherInfo clouds,
                           MainWeatherInfo main, WindWeatherInfo wind, int visibility, Date date) {
        this.id = id;
        this.name = name;
        this.clouds = clouds;
        this.main = main;
        this.wind = wind;
        this.visibility = visibility;
        this.date = date;
    }

    @Override
    public String toString() {
        return "FullWeatherInfo{" +
                "City name " + name +
                ", " + weather
                .toString()
                .replace("[", "")
                .replace("]", "") +
                ", clouds " + clouds +
                ", main " + main +
                ", wind " + wind +
                ", visibility " + visibility +
                '}';
    }
}
