package com.project.SkincareService.service;

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

import com.project.SkincareService.Model.SkincareProduct;
import com.project.SkincareService.Repo.SkincareRepository;

@Service
public class SkincareService {

	@Autowired
	SkincareRepository SkincareRepository;

	@RequestMapping(method = RequestMethod.POST, value = "SkincareProduct/create")
	public void create(@RequestBody SkincareProduct SkincareProductProduct) {
		SkincareRepository.save(SkincareProductProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "SkincareProduct/delete")
	void delete(@RequestBody SkincareProduct SkincareProductProduct) {
		SkincareRepository.delete(SkincareProductProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "SkincareProduct/removeusingid/{id}")
	public void removebyId(@PathVariable String id) {
		SkincareRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "SkincareProduct/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return SkincareRepository.existsById(id);
	}

	@RequestMapping("SkincareProduct/total")
	public long total() {
		return SkincareRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "SkincareProduct/searchbyid/{id}")
	public Optional<SkincareProduct> searchById(@PathVariable String id) {
		return SkincareRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "SkincareProduct/searchallbyid/{ids}")
	public Iterable<SkincareProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return SkincareRepository.findAllById(ids);
	}

	//@RequestMapping("SkincareProduct/getall")
	public List<SkincareProduct> searchAll() {
		List<SkincareProduct> SkincareProductProducts = SkincareRepository.findAll();
		return SkincareProductProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "SkincareProduct/deleteall")
	void removeAll() {
		SkincareRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "SkincareProduct/createall")
	void creatAll(@RequestBody ArrayList<SkincareProduct> SkincareProductProducts) {
		SkincareRepository.saveAll(SkincareProductProducts);
	}

	@RequestMapping(method = RequestMethod.GET, value = "SkincareProduct/getByName/{productName}")
	public SkincareProduct getByName(@PathVariable String productName) {
		List<SkincareProduct> SkincareProducts = SkincareRepository.findAll();
		for (SkincareProduct med : SkincareProducts) {
			if (productName.equals(med.getProductName())) {
				return med;
			}
		}

		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "SkincareProduct/getByPrice/{price}")
	public SkincareProduct getByPrice(@PathVariable Double price) {
		List<SkincareProduct> SkincareProductsprice = SkincareRepository.findAll();
		for (SkincareProduct med : SkincareProductsprice) {
			if (price.equals(med.getPrice())) {
				return med;
			}
		}
		return null;
	}
}
