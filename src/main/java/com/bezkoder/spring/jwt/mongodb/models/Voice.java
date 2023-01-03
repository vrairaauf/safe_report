package com.bezkoder.spring.jwt.mongodb.models;

import org.bson.types.Binary;

public class Voice {
	
	private String name;
	private Binary voice;
	public Binary getVoice() {
		return voice;
	}
	public void setVoice(Binary voice) {
		this.voice = voice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Voice(String name) {
		super();
		this.name = name;
	}
	
	
}
