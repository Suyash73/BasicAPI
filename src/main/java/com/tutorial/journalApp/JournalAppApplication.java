package com.tutorial.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JournalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalAppApplication.class, args);
	}

	//public static RestTemplate restTemplate = new RestTemplate();
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
