package app.model;

public class CloudsWeatherInfo {
    private int all;

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "coverage " + all + "%";
    }
}
