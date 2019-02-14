package com.project.BodycareService.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.BodycareService.Model.BodycareProduct;

public interface BodycareRepository extends MongoRepository<BodycareProduct, String> {
	

}
