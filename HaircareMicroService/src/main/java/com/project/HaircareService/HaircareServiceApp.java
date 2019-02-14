package com.project.HaircareService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HaircareServiceApp {

	
	public static void main(String[] args) {
		SpringApplication.run(HaircareServiceApp.class, args);
	}
}
