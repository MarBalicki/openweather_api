package app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CoordinatesWeatherInfo {
    @Column(name = "longitude")
    private double lon;
    @Column(name = "latitude")
    private double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public CoordinatesWeatherInfo() {
    }
}
