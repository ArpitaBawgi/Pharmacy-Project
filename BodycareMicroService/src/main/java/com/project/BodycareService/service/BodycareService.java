package com.project.BodycareService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.BodycareService.Model.BodycareProduct;
import com.project.BodycareService.Repo.BodycareRepository;

@Service
public class BodycareService {

	@Autowired
	BodycareRepository babycareRepository;

	@RequestMapping(method = RequestMethod.POST, value = "BodycareProduct/create")
	public void create(@RequestBody BodycareProduct BodycareProductProduct) {
		babycareRepository.save(BodycareProductProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "BodycareProduct/delete")
	void delete(@RequestBody BodycareProduct BodycareProductProduct) {
		babycareRepository.delete(BodycareProductProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "BodycareProduct/removeusingid/{id}")
	public void removebyId(@PathVariable String id) {
		babycareRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "BodycareProduct/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return babycareRepository.existsById(id);
	}

	@RequestMapping("BodycareProduct/total")
	public long total() {
		return babycareRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "BodycareProduct/searchbyid/{id}")
	public Optional<BodycareProduct> searchById(@PathVariable String id) {
		return babycareRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "BodycareProduct/searchallbyid/{ids}")
	public Iterable<BodycareProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return babycareRepository.findAllById(ids);
	}

	//@RequestMapping("BodycareProduct/getall")
	public List<BodycareProduct> searchAll() {
		List<BodycareProduct> BodycareProductProducts = babycareRepository.findAll();
		return BodycareProductProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "BodycareProduct/deleteall")
	void removeAll() {
		babycareRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "BodycareProduct/createall")
	void creatAll(@RequestBody ArrayList<BodycareProduct> BodycareProductProducts) {
		babycareRepository.saveAll(BodycareProductProducts);
	}

	@RequestMapping(method = RequestMethod.GET, value = "BodycareProduct/getByName/{productName}")
	public BodycareProduct getByName(@PathVariable String productName) {
		List<BodycareProduct> BodycareProducts = babycareRepository.findAll();
		for (BodycareProduct med : BodycareProducts) {
			if (productName.equals(med.getProductName())) {
				return med;
			}
		}

		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "BodycareProduct/getByPrice/{price}")
	public BodycareProduct getByPrice(@PathVariable Double price) {
		List<BodycareProduct> BodycareProductsprice = babycareRepository.findAll();
		for (BodycareProduct med : BodycareProductsprice) {
			if (price.equals(med.getPrice())) {
				return med;
			}
		}
		return null;
	}
}
