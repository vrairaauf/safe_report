package com.bezkoder.spring.jwt.mongodb.models;

import java.util.Date;

import org.bson.types.Binary;;
public class Image {
	private String name;
	private Binary image;
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
	private Date updated_at;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Image(String name) {
		super();
		this.name = name;
		this.updated_at=new Date();
	}
	
	
}
