package com.project.MedService.controller;

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
import com.project.MedService.Model.Medicine;
import com.project.MedService.controller.MedicineController;
import com.project.MedService.service.MedicineDAO;


@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class MedicineController {

	@Autowired
	private EurekaClient client;
	
	@Autowired
	private MedicineDAO medicinedao;
	
	@RequestMapping("medicinestore/viewallproducts")
	public List<Medicine> viewAllMedicine() {
		return medicinedao.searchAll();
	}

	@RequestMapping("medicinestore/{id}")
	public Optional<Medicine> getProd(@PathVariable String id) {
		return medicinedao.searchById(id);
	}

	@RequestMapping("medicinestore/getByName/{productName}")
	public Medicine getByName(@PathVariable String productName) {
		return medicinedao.getByName(productName);
	}

	@RequestMapping("medicinestore/getByPrice/{price}")
	public Medicine getByPrice(@PathVariable Double price) {
		return medicinedao.getByPrice(price);
	}
}