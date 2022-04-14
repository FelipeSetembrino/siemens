package com.app.WeatherInfo.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.WeatherInfo.data.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
	
	public Location findFirstByLocationName(String locationName);
	
}
