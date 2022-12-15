package com.bezkoder.spring.jwt.mongodb.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jwt.mongodb.repository.MailRepository;

@Service
public class Mail {
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private JavaMailSender javamailsender;
	public void sendMail(String toEmail, String subject, String body) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("vrairaaufabidi@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		javamailsender.send(message);
		
		System.out.println("mail send successfully");
	}
}
