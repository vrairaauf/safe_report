package com.bezkoder.spring.jwt.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.jwt.mongodb.models.Ciphers;

public interface CipherSafeCorruptionRepository extends MongoRepository<Ciphers, String>{
	Optional<Ciphers> findByUser(String user_id);
}
