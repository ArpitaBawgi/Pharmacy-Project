package com.project.HaircareService.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.project.HaircareService.Model.HaircareProduct;

public interface HaircareRepository extends MongoRepository<HaircareProduct, String> {
	

}
