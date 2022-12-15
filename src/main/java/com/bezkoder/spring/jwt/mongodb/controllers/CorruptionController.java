package com.bezkoder.spring.jwt.mongodb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("safecorruption/corruption/api/V1/")
public class CorruptionController {
	
	@GetMapping("test/")
	public String test() {
		return "test_valid";
	}
	
}
