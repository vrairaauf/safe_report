package com.bezkoder.spring.jwt.mongodb.models;

import org.bson.types.Binary;

public class Video {
	
	private String name;
	private Binary video;
	
	public Video(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public Binary getVideo() {
		return video;
	}
	public void setVideo(Binary video) {
		this.video = video;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
