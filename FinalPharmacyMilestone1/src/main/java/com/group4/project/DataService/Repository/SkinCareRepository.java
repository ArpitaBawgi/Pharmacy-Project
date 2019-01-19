package com.group4.project.DataService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group4.project.DataService.Model.SkinCareProduct;

public interface SkinCareRepository extends MongoRepository<SkinCareProduct, String>{

}
