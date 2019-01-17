package com.group4.project.DataService.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.group4.project.DataService.Model.BodyCareProduct;
import com.group4.project.DataService.Model.SkinCareProduct;
import com.group4.project.DataService.Repository.SkinCareRepository;

@RestController
public class SkinCareDAO {

	@Autowired
	SkinCareRepository skinCareRepository;

	@RequestMapping(method = RequestMethod.POST, value = "skincare/create")
	void create(@RequestBody SkinCareProduct skinCareProduct) {
		skinCareRepository.save(skinCareProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "skincare/delete")
	void delete(@RequestBody SkinCareProduct skinCareProduct) {
		skinCareRepository.delete(skinCareProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "skincare/removeusingid/{id}")
	void removebyId(@PathVariable String id) {
		skinCareRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "skincare/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return skinCareRepository.existsById(id);
	}

	@RequestMapping("skincare/total")
	public long total() {
		return skinCareRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "skincare/searchbyid/{id}")
	public Optional<SkinCareProduct> searchById(@PathVariable String id) {
		return skinCareRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "skincare/searchallbyid/{ids}")
	public Iterable<SkinCareProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return skinCareRepository.findAllById(ids);
	}

	@RequestMapping("skincare/getall")
	public List<SkinCareProduct> searchAll() {
		List<SkinCareProduct> skinCareProducts = skinCareRepository.findAll();
		return skinCareProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "skincare/deleteall")
	void removeAll() {
		skinCareRepository.deleteAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "skincare/createall")
	void creatAll(@RequestBody ArrayList<SkinCareProduct> skinCareProducts) {
		skinCareRepository.saveAll(skinCareProducts);
	} 
}
