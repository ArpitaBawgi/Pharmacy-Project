package com.project.HaircareService.controller;

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
import com.project.HaircareService.Model.HaircareProduct;
import com.project.HaircareService.service.HaircareService;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class HaircareController {

	@Autowired
	private EurekaClient client;
	
	@Autowired
	private HaircareService Haircaredao;
	
	@RequestMapping("Haircarestore/viewallproducts")
	public List<HaircareProduct> viewAllMedicine() {
		return Haircaredao.searchAll();
	}

	@RequestMapping("Haircarestore/{id}")
	public Optional<HaircareProduct> getProd(@PathVariable String id) {
		return Haircaredao.searchById(id);
	}

	@RequestMapping("Haircarestore/getByName/{productName}")
	public HaircareProduct getByName(@PathVariable String productName) {
		return Haircaredao.getByName(productName);
	}

	@RequestMapping("Haircarestore/getByPrice/{price}")
	public HaircareProduct getByPrice(@PathVariable Double price) {
		return Haircaredao.getByPrice(price);
	}
}