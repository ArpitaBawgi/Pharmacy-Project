package com.project.MedService.service;

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

import com.project.MedService.Model.Medicine;
import com.project.MedService.Repo.MedicineRepository;

@Service
public class MedicineDAO {

	@Autowired
	MedicineRepository medicineRepository;

	@RequestMapping(method = RequestMethod.POST, value = "medicine/create")
	public void create(@RequestBody Medicine medicineProduct) {
		medicineRepository.save(medicineProduct);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "medicine/delete")
	void delete(@RequestBody Medicine medicineProduct) {
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
	public Optional<Medicine> searchById(@PathVariable String id) {
		return medicineRepository.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "medicine/searchallbyid/{ids}")
	public Iterable<Medicine> searchAllbyId(@PathVariable ArrayList<String> ids) {
		return medicineRepository.findAllById(ids);
	}

	//@RequestMapping("medicine/getall")
	public List<Medicine> searchAll() {
		List<Medicine> medicineProducts = medicineRepository.findAll();
		return medicineProducts;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "medicine/deleteall")
	void removeAll() {
		medicineRepository.deleteAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "medicine/createall")
	void creatAll(@RequestBody ArrayList<Medicine> medicineProducts) {
		medicineRepository.saveAll(medicineProducts);
	}

	@RequestMapping(method = RequestMethod.GET, value = "medicine/getByName/{productName}")
	public Medicine getByName(@PathVariable String productName) {
		List<Medicine> medicines = medicineRepository.findAll();
		for (Medicine med : medicines) {
			if (productName.equals(med.getProductName())) {
				return med;
			}
		}

		return null;
	}

	@RequestMapping(method = RequestMethod.GET, value = "medicine/getByPrice/{price}")
	public Medicine getByPrice(@PathVariable Double price) {
		List<Medicine> medicinesprice = medicineRepository.findAll();
		for (Medicine med : medicinesprice) {
			if (price.equals(med.getPrice())) {
				return med;
			}
		}
		return null;
	}
}
