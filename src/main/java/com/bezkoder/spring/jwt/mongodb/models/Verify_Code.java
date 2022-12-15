package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "verify_code")
public class Verify_Code {
	
	@Id
	private String id;
	
	@NonNull
	private String mail;
	@NonNull
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Verify_Code(String mail, String code) {
		super();
		this.code = code;
		this.mail = mail;
	}
	

}
