package app.repository;

import app.model.FullWeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<FullWeatherInfo, Long> {
}
