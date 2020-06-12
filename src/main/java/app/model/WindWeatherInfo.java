package app.model;

public class WindWeatherInfo {

    private double speed;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "speed " + speed + "m/s";
    }
}
