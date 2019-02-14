package com.project.BabycareService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BabycareServiceApp {

	
	public static void main(String[] args) {
		SpringApplication.run(BabycareServiceApp.class, args);
	}
}
