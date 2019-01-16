package com.group4.project.DataService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group4.project.DataService.Model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
