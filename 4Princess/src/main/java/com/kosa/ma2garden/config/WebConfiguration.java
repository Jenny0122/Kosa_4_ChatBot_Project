package com.kosa.ma2garden.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedOrigins(System.getProperty("os.name")
						.contains("Linux") ? "http://ma2garden.xyz:8080" : "http://localhost:8080")
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.maxAge(3000);

		WebMvcConfigurer.super.addCorsMappings(registry);
	}

}
