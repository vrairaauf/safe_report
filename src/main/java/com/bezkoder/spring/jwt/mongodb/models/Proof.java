package com.bezkoder.spring.jwt.mongodb.models;

public class Proof {
	private String id;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Proof(String id) {
		super();
		this.id = id;
	}
	
	
}
