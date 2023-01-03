package com.bezkoder.spring.jwt.mongodb.models;

import org.bson.types.Binary;

public class FileR {
	private String name;
	private Binary document;
	public FileR(String name) {
		super();
		this.name = name;
	}
	public Binary getDocument() {
		return document;
	}
	public void setDocument(Binary document) {
		this.document = document;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
