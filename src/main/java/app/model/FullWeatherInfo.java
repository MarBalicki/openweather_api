package app.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "weather_info")
//@TypeDefs({
//        @TypeDef(
//                name = "object-array",
//                typeClass = StringArrayType.class
//        )
//})
public class FullWeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name")
    private String name;
    @Embedded
    private CloudsWeatherInfo clouds;
//    @Embedded
//    @Type(type = "object-array")
//    @Column(columnDefinition = "string[]")
//    private WeatherInfo[] weather;
    @Embedded
    private MainWeatherInfo main;
    @Embedded
    private WindWeatherInfo wind;
    private int visibility;
    private Date date;

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

//    public void setWeather(WeatherInfo[] weather) {
////        Optional<WeatherInfo> first = Arrays.stream(weather).findFirst();
////        if (first.isPresent()) {
////            String description = first.get().toString();
////            for (WeatherInfo w : weather) {
////                this.weather = w.setDescription(description);
////            }
////        }
//        this.weather = weather;
//    }

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

//    public WeatherInfo[] getWeather() {
//        return weather;
//    }

    public MainWeatherInfo getMain() {
        return main;
    }

    public WindWeatherInfo getWind() {
        return wind;
    }

    public int getVisibility() {
        return visibility;
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
//        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.visibility = visibility;
        this.date = date;
    }

    @Override
    public String toString() {
        return "FullWeatherInfo{" +
                "City name " + name +
                ", clouds " + clouds +
                ", main " + main +
                ", wind " + wind +
                ", visibility " + visibility +
                '}';
    }
}
