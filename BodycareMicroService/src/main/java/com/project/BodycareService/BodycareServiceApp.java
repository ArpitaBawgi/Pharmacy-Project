package com.project.BodycareService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BodycareServiceApp {

	
	public static void main(String[] args) {
		SpringApplication.run(BodycareServiceApp.class, args);
	}
}
