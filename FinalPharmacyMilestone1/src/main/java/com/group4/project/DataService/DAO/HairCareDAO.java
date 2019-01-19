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

import com.group4.project.DataService.Model.HairCareProduct;
import com.group4.project.DataService.Repository.HairCareRepository;

@RestController
public class HairCareDAO {
	@Autowired
	HairCareRepository hairCareRepository;

	@RequestMapping(method = RequestMethod.POST, value = "haircare/create")
	public void create(@RequestBody HairCareProduct hairCareProduct) {
		hairCareRepository.save(hairCareProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "haircare/remove")
	public void remove(@RequestBody HairCareProduct hairCareProduct) {
		hairCareRepository.delete(hairCareProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "haircare/removeusingid/{id}")
	public void removebyId(@PathVariable String id) {
		hairCareRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "haircare/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return hairCareRepository.existsById(id);
	}

	@RequestMapping("haircare/total")
	public long total() {
		return hairCareRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "haircare/searchbyid/{id}")
	public Optional<HairCareProduct> searchById(@PathVariable String id) {
		return hairCareRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "haircare/searchallbyid/{ids}")
	public Iterable<HairCareProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return hairCareRepository.findAllById(ids);
	}

	@RequestMapping("haircare/getall")
	public List<HairCareProduct> searchAll() {
		List<HairCareProduct> hairCareProducts = hairCareRepository.findAll();
		return hairCareProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "haircare/removeall")
	public void removeAll() {
		hairCareRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "hair/createall")
	public void creatAll(@RequestBody ArrayList<HairCareProduct> hairCareProducts) {
		hairCareRepository.saveAll(hairCareProducts);
	}
}
