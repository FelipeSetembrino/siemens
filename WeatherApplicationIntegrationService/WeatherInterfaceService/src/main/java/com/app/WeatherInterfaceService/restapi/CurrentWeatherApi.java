package com.app.WeatherInterfaceService.restapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.app.WeatherInterfaceService.config.ApplicationConfiguration;
import com.app.WeatherInterfaceService.restapi.structure.CurrentWeatherDataStructure;
import com.google.gson.Gson;

public class CurrentWeatherApi {

	public CurrentWeatherDataStructure getCurrentWeather(String lat, String lon) {
		Map<String, String> map = new HashMap<>();
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("apiKey", ApplicationConfiguration.API_KEY);
		RestTemplate restTemplate = new RestTemplate();
		String url = ApplicationConfiguration.END_POINT; // + "?lat=" + lat + "&lon=" + lon + "&appid=" + ApplicationConfiguration.API_KEY;
		String response = restTemplate.getForObject(url, String.class, map);
		return (CurrentWeatherDataStructure) new Gson().fromJson(response, CurrentWeatherDataStructure.class);
	}
	
}
