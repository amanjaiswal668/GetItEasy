package com.zensar;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class JwTtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwTtestApplication.class, args);
	}

	@SuppressWarnings("deprecation")

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH").allowedOrigins("http://localhost:4200").allowedHeaders("*");
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			
			}
		};
	}

	/*
	 * @Bean public CorsFilter corsFilter() { CorsConfiguration corsConfiguration =
	 * new CorsConfiguration(); corsConfiguration.setAllowCredentials(true);
	 * corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	 * corsConfiguration.setAllowedHeaders(Arrays.asList("Origin",
	 * "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization",
	 * "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method",
	 * "Access-Control-Request-Headers", "username",
	 * "Access-Control-Allow-Headers"));
	 * corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type",
	 * "Accept", "Authorization", "Access-Control-Allow-Origin",
	 * "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials",
	 * "Access-Control-Allow-Headers"));
	 * corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
	 * "DELETE", "OPTIONS")); UrlBasedCorsConfigurationSource
	 * urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
	 * urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",
	 * corsConfiguration); return new CorsFilter(urlBasedCorsConfigurationSource); }
	 */
}
