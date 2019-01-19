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
import com.group4.project.DataService.Repository.BodyCareRepository;

@RestController
public class BodyCareDAO {

	@Autowired
	BodyCareRepository bodyCareRepository;

	@RequestMapping(method = RequestMethod.POST, value = "bodycare/create")
	public void create(@RequestBody BodyCareProduct bodyCareProduct) {
		bodyCareRepository.save(bodyCareProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "bodycare/remove")
	public void remove(@RequestBody BodyCareProduct bodyCareProduct) {
		bodyCareRepository.delete(bodyCareProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "bodycare/removeusingid/{id}")
	public void removebyId(@PathVariable String id) {
		bodyCareRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "bodycare/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return bodyCareRepository.existsById(id);
	}

	@RequestMapping("bodycare/total")
	public long total() {
		return bodyCareRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "bodycare/searchbyid/{id}")
	public Optional<BodyCareProduct> searchById(@PathVariable String id) {
		Optional<BodyCareProduct> bodyCareList = bodyCareRepository.findById(id);
		return bodyCareList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "bodycare/searchallbyid/{ids}")
	public Iterable<BodyCareProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return bodyCareRepository.findAllById(ids);
	}

	@RequestMapping("bodycare/getall")
	public List<BodyCareProduct> searchAll() {
		List<BodyCareProduct> bodyCareProducts = bodyCareRepository.findAll();
		return bodyCareProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "bodycare/removeall")
	public void removeAll() {
		bodyCareRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "body/createall")

	public void creatAll(@RequestBody ArrayList<BodyCareProduct> bodyCareProducts) {
		bodyCareRepository.saveAll(bodyCareProducts);
	}
}
