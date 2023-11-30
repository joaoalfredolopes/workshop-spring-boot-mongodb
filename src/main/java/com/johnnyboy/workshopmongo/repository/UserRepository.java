package com.johnnyboy.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.johnnyboy.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
