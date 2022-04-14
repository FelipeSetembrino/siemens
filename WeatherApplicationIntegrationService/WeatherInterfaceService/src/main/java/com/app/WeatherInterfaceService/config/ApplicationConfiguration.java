package com.app.WeatherInterfaceService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class ApplicationConfiguration {

    @Autowired
    private Environment env;
    public static String END_POINT;
    public static String API_KEY;
    
    @Bean
    public void getProperties() {
        END_POINT = env.getProperty("endPoint");
        API_KEY = env.getProperty("apiKey");
    }

}