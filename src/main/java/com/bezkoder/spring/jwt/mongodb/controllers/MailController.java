package com.bezkoder.spring.jwt.mongodb.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jwt.mongodb.models.Mail;
import com.bezkoder.spring.jwt.mongodb.models.Verify_Code;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.MailRepository;
import com.bezkoder.spring.jwt.mongodb.services.MailService;

@RestController
@RequestMapping("/safeobserve/V1/mailer")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/{mail}")
	public ResponseEntity<?> welcome(@PathVariable String mail) {
		try {
			if(!mailService.existsByMail(mail)) {
				int code=(int) ((int) 1+( Math.random()*100000));
				mailService.save(new Verify_Code(mail, String.valueOf(code)));
				mailService.sendMail(mail, "test mailing from spring boot ", String.valueOf(code));
				return ResponseEntity
						.ok(new MessageResponse("verify code sended successfully"));
			}else {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("email lready in use"));
			}
		}catch(Exception error) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("error"));
		}
	}
	
	@PostMapping("verify/")
	public ResponseEntity<?> verify_account(@RequestBody Verify_Code code) {
		if(mailService.existsByMail(code.getMail())) {
			if(mailService.findByMail(code)) {
				return ResponseEntity
						.ok(new MessageResponse("email has been verified"));
			}
		}
		return ResponseEntity
				.badRequest()
				.body(new MessageResponse("this is invalid code"));
		
	}
}
