package com.project.BodycareService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.web.client.RestTemplateBuilder;

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
import com.project.BodycareService.Model.BodycareProduct;
import com.project.BodycareService.service.BodycareService;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class BodycareController {

	@Autowired
	private EurekaClient client;
	
	@Autowired
	private BodycareService bodycaredao;
	
	@RequestMapping("bodycarestore/viewallproducts")
	public List<BodycareProduct> viewAllMedicine() {
		return bodycaredao.searchAll();
	}

	@RequestMapping("bodycarestore/{id}")
	public Optional<BodycareProduct> getProd(@PathVariable String id) {
		return bodycaredao.searchById(id);
	}

	@RequestMapping("bodycarestore/getByName/{productName}")
	public BodycareProduct getByName(@PathVariable String productName) {
		return bodycaredao.getByName(productName);
	}

	@RequestMapping("bodycarestore/getByPrice/{price}")
	public BodycareProduct getByPrice(@PathVariable Double price) {
		return bodycaredao.getByPrice(price);
	}
}