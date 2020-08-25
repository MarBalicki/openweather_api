package app.model;

public class MainWeatherInfo {

    private double temp;
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

    @Override
    public String toString() {
        return "temp " + ((int) kelvinToCelsius(temp)) + "\u00B0C" +
                ", feels like " + ((int) kelvinToCelsius(feels_like)) + "\u00B0C" +
                ", pressure " + pressure + "hPa" +
                ", humidity " + humidity + "%";
    }

    private double kelvinToCelsius(double temp) {
        return temp - 273.15;
    }
}
