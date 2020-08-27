package app.model;

import javax.persistence.*;

@Entity
@Table(name = "weather_description")
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String main;
    private String icon;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FullWeatherInfo fullWeatherInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public FullWeatherInfo getFullWeatherInfo() {
        return fullWeatherInfo;
    }

    public void setFullWeatherInfo(FullWeatherInfo fullWeatherInfo) {
        this.fullWeatherInfo = fullWeatherInfo;
    }

    public WeatherInfo() {
    }

    @Override
    public String toString() {
        return "description " + description;
    }
}
