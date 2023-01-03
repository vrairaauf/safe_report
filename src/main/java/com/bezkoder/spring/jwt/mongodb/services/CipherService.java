package com.bezkoder.spring.jwt.mongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jwt.mongodb.models.Ciphers;
import com.bezkoder.spring.jwt.mongodb.repository.CipherSafeCorruptionRepository;

@Service
public class CipherService {
	@Autowired
	private CipherSafeCorruptionRepository cipherRepository;
	
	public ResponseEntity<?> save(Ciphers cipher){
		return ResponseEntity.ok(cipherRepository.save(cipher));
	}
	public ResponseEntity<?> retrieve_by_user_id(String user_id){
		return ResponseEntity.ok(cipherRepository.findByUser(user_id));
	}
	public ResponseEntity<?> retrieve(String id){
		return ResponseEntity.ok(cipherRepository.findById(id));
	}
	public ResponseEntity<?> all(){
		return ResponseEntity.ok(cipherRepository.findAll());
	}
}
