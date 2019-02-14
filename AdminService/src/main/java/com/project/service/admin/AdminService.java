package com.project.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.project.service.model.Admin;


@EnableDiscoveryClient
@SpringBootApplication
public class AdminService {

	@Autowired
	private EurekaClient client;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	
	@RequestMapping(method=RequestMethod.POST, value="adminmedicine/add")
	public void addProduct() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("adminservice", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		
		ResponseEntity<List<Admin>> response = restTemplate.exchange(baseUrl + "adminmedicine/add", HttpMethod.POST, null,
				new ParameterizedTypeReference<List<Admin>>() {
				});
	}
	
	
}
