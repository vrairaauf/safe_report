package com.bezkoder.spring.jwt.mongodb.models;

import java.util.Date;
import java.util.List;

public class Corruption {
	private String id;
	private Date date;
	private String content;
	private List<Proof> proofs;
	private int truth;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Proof> getProofs() {
		return proofs;
	}
	public void setProofs(List<Proof> proofs) {
		this.proofs = proofs;
	}
	public int getTruth() {
		return truth;
	}
	public void setTruth(int truth) {
		this.truth = truth;
	}
	public Corruption(String id, Date date, String content, int truth) {
		this.id = id;
		this.date = date;
		this.content = content;
		this.truth = truth;
	}
	
	
	
	
}
