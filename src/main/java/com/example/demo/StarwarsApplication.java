package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableCaching
public class StarwarsApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);
	}

}
