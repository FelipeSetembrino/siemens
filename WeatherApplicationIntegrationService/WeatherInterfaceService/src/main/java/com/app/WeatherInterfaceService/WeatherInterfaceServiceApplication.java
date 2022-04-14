package com.app.WeatherInterfaceService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WeatherInterfaceServiceApplication {

	//private static final Logger log = LoggerFactory.getLogger(WeatherInterfaceServiceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherInterfaceServiceApplication.class, args);
	}
	
    @Value("${cors}")
    private String CORS;
    
    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/current-weather").allowedOrigins(CORS);
			}
		};
	}
	
	/*
	@Bean
	public void testApi() {
		CurrentWeatherApi cwa = new CurrentWeatherApi();
		CurrentWeatherDataStructure cwds = cwa.getCurrentWeather(35+"", 139+"");
		log.info(new Gson().toJson(cwds));
	}
	*/

}
