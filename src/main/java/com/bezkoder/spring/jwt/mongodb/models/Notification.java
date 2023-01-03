package com.bezkoder.spring.jwt.mongodb.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="notification")
public class Notification {
	@Id
	private String id;
	private String libelle;
	private String content;
	private Date date;
	private String user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUser_id() {
		return user;
	}
	public void setUser_id(String user_id) {
		this.user = user_id;
	}
	public Notification(String id, String libelle, String content, Date date, String user) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.content = content;
		this.date = date;
		this.user = user;
	}
	
}
