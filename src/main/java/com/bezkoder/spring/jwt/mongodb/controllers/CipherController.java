package com.bezkoder.spring.jwt.mongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jwt.mongodb.models.Ciphers;
import com.bezkoder.spring.jwt.mongodb.services.CipherService;

@RestController
@RequestMapping("safecorruption/api/v1/user/cipher/")
public class CipherController {
	
	@Autowired
	private CipherService cipherService;
	
	@PostMapping("new/cipher")
	public ResponseEntity<?> create_cipher(@RequestBody Ciphers cipher){
		return cipherService.save(cipher);
	}
	
	@GetMapping("all/")
	public ResponseEntity<?> find_all(){
		return cipherService.all();
	}
	@GetMapping("one/{id}")
	public ResponseEntity<?> find_by_user_id(@PathVariable String id){
		return cipherService.retrieve_by_user_id(id);
	}
	@GetMapping("{id}")
	public ResponseEntity<?> retrieve(@PathVariable String id){
		return cipherService.retrieve(id);
	}
	
	
}
