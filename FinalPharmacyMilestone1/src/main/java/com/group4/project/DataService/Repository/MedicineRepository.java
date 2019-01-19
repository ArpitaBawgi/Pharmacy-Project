package com.group4.project.DataService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group4.project.DataService.Model.MedicineProduct;

public interface MedicineRepository extends MongoRepository<MedicineProduct, String> {

}
