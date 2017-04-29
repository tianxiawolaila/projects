package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.SessionAttributes;

@SpringBootApplication
@SessionAttributes("app5")
public class WebAppApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(WebAppApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}
}
