package app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WindWeatherInfo {

    @Column(name = "speed_mps")
    private double speed;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public WindWeatherInfo() {
    }
    public WindWeatherInfo(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "speed " + speed + "m/s";
    }
}
