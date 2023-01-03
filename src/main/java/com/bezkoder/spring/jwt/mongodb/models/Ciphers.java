package com.bezkoder.spring.jwt.mongodb.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ciphers")
public class Ciphers {
	@Id
	private String id;
	private String user;
	private String key;
	private Date created_at;
	public Ciphers(String id, String user_id, String key, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.user = user;
		this.key = key;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user;
	}
	public void setUser_id(String user_id) {
		this.user = user_id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	private Date updated_at;
}
