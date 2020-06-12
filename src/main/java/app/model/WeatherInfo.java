package app.model;

public class WeatherInfo {
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "description " + description;
    }
}
