package com.project.MedService.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.MedService.Model.Medicine;

public interface MedicineRepository extends MongoRepository<Medicine, String> {
	

}
