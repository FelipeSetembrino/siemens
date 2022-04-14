package com.app.WeatherInterfaceService.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.WeatherInterfaceService.restapi.CurrentWeatherApi;
import com.app.WeatherInterfaceService.restapi.structure.CurrentWeatherDataStructure;

@RestController
public class CurrentWeatherController {

	@GetMapping("/api/current-weather")
	public CurrentWeatherDataStructure getCurrentWeatherByLocation(@Param("lat") Long lat, @Param("lon") Long lon) {
		CurrentWeatherApi cwa = new CurrentWeatherApi();
		return cwa.getCurrentWeather(lat+"", lon+"");
	}
	
}
