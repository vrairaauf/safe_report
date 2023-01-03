package com.bezkoder.spring.jwt.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.jwt.mongodb.models.Criminal;

public interface CriminalRepository extends MongoRepository<Criminal, String>{

}
