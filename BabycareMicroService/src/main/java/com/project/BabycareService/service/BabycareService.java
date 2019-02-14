package com.project.BabycareService.service;

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

import com.project.BabycareService.Model.BabycareProduct;
import com.project.BabycareService.Repo.BabycareRepository;

@Service
public class BabycareService {

	@Autowired
	BabycareRepository babycareRepository;

	@RequestMapping(method = RequestMethod.POST, value = "BabycareProduct/create")
	public void create(@RequestBody BabycareProduct BabycareProductProduct) {
		babycareRepository.save(BabycareProductProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "BabycareProduct/delete")
	void delete(@RequestBody BabycareProduct BabycareProductProduct) {
		babycareRepository.delete(BabycareProductProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "BabycareProduct/removeusingid/{id}")
	public void removebyId(@PathVariable String id) {
		babycareRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "BabycareProduct/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return babycareRepository.existsById(id);
	}

	@RequestMapping("BabycareProduct/total")
	public long total() {
		return babycareRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "BabycareProduct/searchbyid/{id}")
	public Optional<BabycareProduct> searchById(@PathVariable String id) {
		return babycareRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "BabycareProduct/searchallbyid/{ids}")
	public Iterable<BabycareProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return babycareRepository.findAllById(ids);
	}

	//@RequestMapping("BabycareProduct/getall")
	public List<BabycareProduct> searchAll() {
		List<BabycareProduct> BabycareProductProducts = babycareRepository.findAll();
		return BabycareProductProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "BabycareProduct/deleteall")
	void removeAll() {
		babycareRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "BabycareProduct/createall")
	void creatAll(@RequestBody ArrayList<BabycareProduct> BabycareProductProducts) {
		babycareRepository.saveAll(BabycareProductProducts);
	}

	@RequestMapping(method = RequestMethod.GET, value = "BabycareProduct/getByName/{productName}")
	public BabycareProduct getByName(@PathVariable String productName) {
		List<BabycareProduct> BabycareProducts = babycareRepository.findAll();
		for (BabycareProduct med : BabycareProducts) {
			if (productName.equals(med.getProductName())) {
				return med;
			}
		}

		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "BabycareProduct/getByPrice/{price}")
	public BabycareProduct getByPrice(@PathVariable Double price) {
		List<BabycareProduct> BabycareProductsprice = babycareRepository.findAll();
		for (BabycareProduct med : BabycareProductsprice) {
			if (price.equals(med.getPrice())) {
				return med;
			}
		}
		return null;
	}
}
