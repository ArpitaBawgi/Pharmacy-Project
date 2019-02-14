package com.project.BabycareService.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.BabycareService.Model.BabycareProduct;

public interface BabycareRepository extends MongoRepository<BabycareProduct, String> {
	

}
