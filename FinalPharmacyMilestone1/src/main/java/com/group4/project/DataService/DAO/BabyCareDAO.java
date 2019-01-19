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

import com.group4.project.DataService.Model.BabyCareProduct;
import com.group4.project.DataService.Repository.BabyCareRepository;

@RestController
public class BabyCareDAO {

	@Autowired
	BabyCareRepository babyCareRepository;

	@RequestMapping(method = RequestMethod.POST, value = "babycare/create")
	public void create(@RequestBody BabyCareProduct babyCareProduct) {
		babyCareRepository.save(babyCareProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "babycare/remove")
	public void remove(@RequestBody BabyCareProduct babyCareProduct) {
		babyCareRepository.delete(babyCareProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "babycare/removeusingid/{id}")
	public void removebyId(@PathVariable String id) {
		babyCareRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "babycare/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return babyCareRepository.existsById(id);
	}

	@RequestMapping("babycare/total")
	public long total() {
		return babyCareRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "babycare/searchbyid/{id}")
	public Optional<BabyCareProduct> searchById(@PathVariable String id) {
		return babyCareRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "babycare/searchallbyid/{ids}")
	public Iterable<BabyCareProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return babyCareRepository.findAllById(ids);
	}

	@RequestMapping("babycare/getall")
	public List<BabyCareProduct> searchAll() {
		List<BabyCareProduct> babyCareProducts = babyCareRepository.findAll();
		return babyCareProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "babycare/removeall")
	public void removeAll() {
		babyCareRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "baby/createall")
	public void creatAll(@RequestBody ArrayList<BabyCareProduct> babyCareProducts) {
		babyCareRepository.saveAll(babyCareProducts);
	}
}
