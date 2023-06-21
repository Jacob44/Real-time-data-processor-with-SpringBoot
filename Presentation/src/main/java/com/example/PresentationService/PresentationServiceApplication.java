package com.example.PresentationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient

public class PresentationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PresentationServiceApplication.class, args);
	}

}
