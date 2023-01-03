package com.bezkoder.spring.jwt.mongodb.controllers;

import java.util.List;

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

import com.bezkoder.spring.jwt.mongodb.models.Image;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.services.UserService;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("safecorruption/user/media/api/V1/")
public class UserFixeController {

	@Autowired
	private UserService userService;
	
	@GetMapping("user/verify/{id}")
	public ResponseEntity<?> update_user(@PathVariable String id) {
		User user=userService.retrieve_user(id).get();
		user.setIs_verified(true);
		return ResponseEntity.ok(userService.updateUser(id, user));
	}
	
	@PostMapping("user/profile/image")
	public ResponseEntity<?> make_profile_image(@RequestParam("user") String user_id, @RequestParam("title") String title, @RequestParam("image") MultipartFile image)throws IOException, java.io.IOException {
		userService.make_image_profile(user_id, title, image);
		return retrieve_user(user_id);
	}
	
	@GetMapping("users/all/")
	public ResponseEntity<?> get_all_users(){
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping("users/one/{id}")
	public ResponseEntity retrieve_user(@PathVariable String id) {
		return ResponseEntity.ok(userService.retrieve_user(id));
	}
	
	
}
