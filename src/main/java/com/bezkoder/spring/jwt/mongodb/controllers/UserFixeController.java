package com.bezkoder.spring.jwt.mongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.services.UserService;

@RestController
@RequestMapping("safecorruption/user/media/api/V1/")
public class UserFixeController {

	@Autowired
	private UserService userService;
	
	@PostMapping("user/verify/{id}")
	public ResponseEntity<?> update_user(@RequestBody User user, @PathVariable String id) {
		return ResponseEntity.ok(userService.updateUser(id, user));
	}
	
	/*@PostMaping(user/media/image)
	public User make_profile_image(@RequestMapping Image image, @PathVariable String id) {
		
	}
	*/
	@GetMapping("users/all/")
	public ResponseEntity<?> get_all_users(){
		return ResponseEntity.ok(userService.findAll());
	}
	@GetMapping("users/one/{id}")
	public ResponseEntity retrieve_user(@PathVariable String id) {
		return ResponseEntity.ok(userService.retrieve_user(id));
	}
	
	
}
