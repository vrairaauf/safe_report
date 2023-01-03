package com.bezkoder.spring.jwt.mongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.spring.jwt.mongodb.models.Criminal;
import com.bezkoder.spring.jwt.mongodb.services.CriminalService;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("safecorruption/api/v1/criminal/")
public class CriminalController {

	
	@Autowired 
	private CriminalService criminalService;
	
	@PostMapping("new/criminal")
	public ResponseEntity<?> create_criminal(@RequestBody Criminal criminal){
		return criminalService.save(criminal);
	}
	
	@GetMapping("all/")
	public ResponseEntity<?> all(){
		return criminalService.all();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> retrieve_criminal(@PathVariable String id){
		return criminalService.retrieve_criminal(id);
	}
	@PostMapping("image")
	public ResponseEntity<?> make_criminal_image(@RequestParam("criminal_id") String criminal_id, @RequestParam("image") MultipartFile image)throws IOException, java.io.IOException {
		criminalService.make_criminal_image(criminal_id, image);
		return criminalService.retrieve_criminal(criminal_id);
	}
}
