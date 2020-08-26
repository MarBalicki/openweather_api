package app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CloudsWeatherInfo {
    @Column(name = "clouds_coverage")
    private int all;

    public void setAll(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    public CloudsWeatherInfo() {
    }
    public CloudsWeatherInfo(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "coverage " + all + "%";
    }
}
