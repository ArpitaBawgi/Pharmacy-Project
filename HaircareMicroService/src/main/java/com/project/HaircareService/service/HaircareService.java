package com.project.HaircareService.service;

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

import com.project.HaircareService.Model.HaircareProduct;
import com.project.HaircareService.Repo.HaircareRepository;

@Service
public class HaircareService {

	@Autowired
	HaircareRepository haircareRepository;

	@RequestMapping(method = RequestMethod.POST, value = "HaircareProduct/create")
	public void create(@RequestBody HaircareProduct HaircareProductProduct) {
		haircareRepository.save(HaircareProductProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "HaircareProduct/delete")
	void delete(@RequestBody HaircareProduct HaircareProductProduct) {
		haircareRepository.delete(HaircareProductProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "HaircareProduct/removeusingid/{id}")
	public void removebyId(@PathVariable String id) {
		haircareRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "HaircareProduct/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return haircareRepository.existsById(id);
	}

	@RequestMapping("HaircareProduct/total")
	public long total() {
		return haircareRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "HaircareProduct/searchbyid/{id}")
	public Optional<HaircareProduct> searchById(@PathVariable String id) {
		return haircareRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "HaircareProduct/searchallbyid/{ids}")
	public Iterable<HaircareProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return haircareRepository.findAllById(ids);
	}

	//@RequestMapping("HaircareProduct/getall")
	public List<HaircareProduct> searchAll() {
		List<HaircareProduct> HaircareProductProducts = haircareRepository.findAll();
		return HaircareProductProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "HaircareProduct/deleteall")
	void removeAll() {
		haircareRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "HaircareProduct/createall")
	void creatAll(@RequestBody ArrayList<HaircareProduct> HaircareProductProducts) {
		haircareRepository.saveAll(HaircareProductProducts);
	}

	@RequestMapping(method = RequestMethod.GET, value = "HaircareProduct/getByName/{productName}")
	public HaircareProduct getByName(@PathVariable String productName) {
		List<HaircareProduct> HaircareProducts = haircareRepository.findAll();
		for (HaircareProduct med : HaircareProducts) {
			if (productName.equals(med.getProductName())) {
				return med;
			}
		}

		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "HaircareProduct/getByPrice/{price}")
	public HaircareProduct getByPrice(@PathVariable Double price) {
		List<HaircareProduct> HaircareProductsprice = haircareRepository.findAll();
		for (HaircareProduct med : HaircareProductsprice) {
			if (price.equals(med.getPrice())) {
				return med;
			}
		}
		return null;
	}
}
