package com.bezkoder.spring.jwt.mongodb.services;

import java.io.IOException;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.spring.jwt.mongodb.models.Criminal;
import com.bezkoder.spring.jwt.mongodb.models.Image;
import com.bezkoder.spring.jwt.mongodb.repository.CriminalRepository;

@Service
public class CriminalService {
	
	@Autowired
	private CriminalRepository criminalRepository;
	
	public ResponseEntity<?> save(Criminal criminal){
		criminalRepository.save(criminal);
		return ResponseEntity.ok(criminal);
	}
	
	public ResponseEntity<?> all(){
		return ResponseEntity.ok(criminalRepository.findAll());
	}
	public ResponseEntity<?> retrieve_criminal(String id){
		return ResponseEntity.ok(criminalRepository.findById(id));
	}

	public void make_criminal_image(String criminal_id, MultipartFile image) throws IOException {
		
		Image criminal_image = new Image(image.getName()); 
		criminal_image.setImage(
          new Binary(BsonBinarySubType.BINARY, image.getBytes())
          ); 
        Optional<Criminal> criminal=criminalRepository.findById(criminal_id);
        
        criminal.get().setImage(criminal_image);;
        criminalRepository.save(criminal.get());
        
	}
}
