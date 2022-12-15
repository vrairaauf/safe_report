package com.bezkoder.spring.jwt.mongodb.models;

import java.util.Date;;
public class Image {
	private String name;
	private String path;
	private Date updated_at;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Image(String name, String path) {
		super();
		this.name = name;
		this.path = path;
		this.updated_at=new Date();
	}
	
	
}
