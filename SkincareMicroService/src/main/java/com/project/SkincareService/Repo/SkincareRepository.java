package com.project.SkincareService.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.SkincareService.Model.SkincareProduct;

public interface SkincareRepository extends MongoRepository<SkincareProduct, String> {
	

}
