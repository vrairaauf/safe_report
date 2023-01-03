package com.bezkoder.spring.jwt.mongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import com.bezkoder.spring.jwt.mongodb.services.UserService;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("safecorruption/corruption/api/V1/")
public class CorruptionController {
	
	@GetMapping("test/")
	public String test() {
		return "test_valid";
	}
	
	@Autowired
	private UserService userService;
	@PostMapping("user/corruption")
	public ResponseEntity<?> make_report(
			@RequestParam("user") String user_id, 
			@RequestParam("content") String content,
			@RequestParam("truth") String truth,
			@RequestParam("has_proofs") String has_proofs,
			@RequestParam("has_images_proofs") String has_images_proofs,
			@RequestParam("images_proofs") List<MultipartFile> images_proofs,
			@RequestParam("images_proofs_description") String images_proofs_description,
			
			@RequestParam("has_videos_proofs") String has_videos_proofs,
			@RequestParam("videos_proofs") List<MultipartFile> videos_proofs,
			@RequestParam("videos_proofs_description") String videos_proofs_description,
			
			@RequestParam("has_voices_proofs") String has_voices_proofs,
			@RequestParam("voices_proofs") List<MultipartFile> voices_proofs,
			@RequestParam("voices_proofs_description") String voices_proofs_description,
			
			@RequestParam("has_documents_proofs") String has_documents_proofs,
			@RequestParam("documents_proofs") List<MultipartFile> documents_proofs,
			@RequestParam("documents_proofs_description") String documents_proofs_description,
			
			@RequestParam("has_locations_proofs") String has_locations_proofs,
			@RequestParam("locations_proofs") String locations_proofs,
			@RequestParam("locations_proofs_description") String locations_proofs_description
			
			) throws IOException, java.io.IOException{
				try {
				userService.make_corruption(
											user_id, 
											content, 
											truth,
											has_proofs, 
											has_images_proofs, 
											images_proofs, 
											images_proofs_description,
											has_videos_proofs, 
											videos_proofs, 
											videos_proofs_description,
											has_voices_proofs, 
											voices_proofs,
											voices_proofs_description,
											has_documents_proofs, 
											documents_proofs, 
											documents_proofs_description,
											has_locations_proofs, 
											locations_proofs,
											locations_proofs_description
											);
				return ResponseEntity.ok("report sended successfully");
				}
				catch (Exception e) {
					return ResponseEntity.ok(e.getMessage());
				}
				}
}
