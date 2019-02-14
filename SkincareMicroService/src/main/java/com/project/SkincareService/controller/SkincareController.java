package com.project.SkincareService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.project.SkincareService.Model.SkincareProduct;
import com.project.SkincareService.service.SkincareService;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class SkincareController {

	@Autowired
	private EurekaClient client;
	
	@Autowired
	private SkincareService Skincaredao;
	
	@RequestMapping("Skincarestore/viewallproducts")
	public List<SkincareProduct> viewAllMedicine() {
		return Skincaredao.searchAll();
	}

	@RequestMapping("Skincarestore/{id}")
	public Optional<SkincareProduct> getProd(@PathVariable String id) {
		return Skincaredao.searchById(id);
	}

	@RequestMapping("Skincarestore/getByName/{productName}")
	public SkincareProduct getByName(@PathVariable String productName) {
		return Skincaredao.getByName(productName);
	}

	@RequestMapping("Skincarestore/getByPrice/{price}")
	public SkincareProduct getByPrice(@PathVariable Double price) {
		return Skincaredao.getByPrice(price);
	}
}