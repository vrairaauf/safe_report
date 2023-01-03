package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "criminals")
public class Criminal {
	@Id
	private String id;
	private String complete_name;
	private int age;
	private String dsecription;
	private Image image;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComplete_name() {
		return complete_name;
	}
	public void setComplete_name(String complete_name) {
		this.complete_name = complete_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDsecription() {
		return dsecription;
	}
	public void setDsecription(String dsecription) {
		this.dsecription = dsecription;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Criminal(String id, String complete_name, int age, String dsecription, Image image) {
		super();
		this.id = id;
		this.complete_name = complete_name;
		this.age = age;
		this.dsecription = dsecription;
		this.image = image;
	}
	
}
