package com.example.JDRSlistin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JdrSlistinApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdrSlistinApplication.class, args);
	}

}
