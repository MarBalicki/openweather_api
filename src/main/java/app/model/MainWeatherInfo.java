package app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MainWeatherInfo {

    @Column(name = "temp_\u00B0C")
    private double temp;
    @Column(name = "feels_like_\u00B0C")
    private double feels_like;
    private int pressure;
    private int humidity;

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp() {
        return twoDigitsAfterDot(temp);
    }

    public double getFeels_like() {
        return twoDigitsAfterDot(feels_like);
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public MainWeatherInfo() {
    }

    public MainWeatherInfo(double temp, double feels_like, int pressure, int humidity) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.pressure = pressure;
        this.humidity = humidity;
    }


    @Override
    public String toString() {
        return "temp " +  twoDigitsAfterDot(temp) + "\u00B0C" +
                ", feels like " + twoDigitsAfterDot(feels_like) + "\u00B0C" +
                ", pressure " + pressure + "hPa" +
                ", humidity " + humidity + "%";
    }

    private double twoDigitsAfterDot(double temp) {
        if (temp > 0) {
            return Math.floor(temp * 100) / 100;
        } else {
            return Math.ceil(temp * 100) / 100;
        }
    }
}
