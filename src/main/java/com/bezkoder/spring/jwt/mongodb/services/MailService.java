package com.bezkoder.spring.jwt.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jwt.mongodb.models.Mail;
import com.bezkoder.spring.jwt.mongodb.models.Verify_Code;
import com.bezkoder.spring.jwt.mongodb.repository.MailRepository;

@Service
public class MailService {
	@Autowired
	private MailRepository mailRepository;
	
	@Autowired
	private Mail mails;
	
	public Boolean existsByMail(String mail) {
		return mailRepository.existsByMail(mail);
	}
	
	public void save(Verify_Code verify_code) {
		mailRepository.save(verify_code);
		return;
	}
	
	public boolean findByMail(Verify_Code code){
		Optional<Verify_Code> code_from_db=mailRepository.findByMail(code.getMail());
		if(code_from_db.isEmpty()) {
			return false;
		}else {
			if(code_from_db.get().getCode().equals(code.getCode())) {
				return true;
			}
		}
		return false;
	}
	public void sendMail(String to_mail, String subject, String body) {
		mails.sendMail(to_mail, subject, body);
	}
	
	
}
