package com.project.BabycareService.controller;

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

import com.project.BabycareService.Model.BabycareProduct;
import com.project.BabycareService.controller.BabycareController;
import com.project.BabycareService.service.BabycareService;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class BabycareController {

	@Autowired
	private EurekaClient client;
	
	@Autowired
	private BabycareService babycaredao;
	
	@RequestMapping("babycarestore/viewallproducts")
	public List<BabycareProduct> viewAllMedicine() {
		return babycaredao.searchAll();
	}

	@RequestMapping("babycarestore/{id}")
	public Optional<BabycareProduct> getProd(@PathVariable String id) {
		return babycaredao.searchById(id);
	}

	@RequestMapping("babycarestore/getByName/{productName}")
	public BabycareProduct getByName(@PathVariable String productName) {
		return babycaredao.getByName(productName);
	}

	@RequestMapping("babycarestore/getByPrice/{price}")
	public BabycareProduct getByPrice(@PathVariable Double price) {
		return babycaredao.getByPrice(price);
	}
}