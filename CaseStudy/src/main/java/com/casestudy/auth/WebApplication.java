package com.casestudy.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * The WebApplication class is used simply to begin the
 * Spring Boot application.
 */
@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebApplication.class, args);
	}
}