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

import com.group4.project.DataService.Model.MedicineProduct;
import com.group4.project.DataService.Repository.MedicineRepository;

@RestController
public class MedicineDAO {

	@Autowired
	MedicineRepository medicineRepository;

	@RequestMapping(method = RequestMethod.POST, value = "medicine/create")

	public void create(@RequestBody MedicineProduct medicineProduct) {
		medicineRepository.save(medicineProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "medicine/remove")
	public void remove(@RequestBody MedicineProduct medicineProduct) {
		medicineRepository.delete(medicineProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "medicine/removeusingid/{id}")
	public void removebyId(@PathVariable String id) {
		medicineRepository.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "medicine/present/{id}")
	public boolean isPresent(@PathVariable String id) {
		return medicineRepository.existsById(id);
	}

	@RequestMapping("medicine/total")
	public long total() {
		return medicineRepository.count();
	}

	@RequestMapping(method = RequestMethod.GET, value = "medicine/searchbyid/{id}")
	public Optional<MedicineProduct> searchById(@PathVariable String id) {
		return medicineRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "medicine/searchallbyid/{ids}")
	public Iterable<MedicineProduct> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return medicineRepository.findAllById(ids);
	}

	@RequestMapping("medicine/getall")
	public List<MedicineProduct> searchAll() {
		List<MedicineProduct> medicineProducts = medicineRepository.findAll();
		return medicineProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "medicine/removeall")
	public void removeAll() {
		medicineRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "medicine/createall")
	public void creatAll(@RequestBody ArrayList<MedicineProduct> medicineProducts) {
		medicineRepository.saveAll(medicineProducts);
	}
}
