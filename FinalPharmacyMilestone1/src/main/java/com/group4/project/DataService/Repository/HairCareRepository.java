package com.group4.project.DataService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group4.project.DataService.Model.HairCareProduct;

public interface HairCareRepository extends MongoRepository<HairCareProduct, String>{

}
