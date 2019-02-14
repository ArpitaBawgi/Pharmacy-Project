package com.project.loginregister.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.loginregister.model.User;



public interface UserRepository extends MongoRepository<User, String> {

}

