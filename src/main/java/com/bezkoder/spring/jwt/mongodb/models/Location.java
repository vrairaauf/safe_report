package com.bezkoder.spring.jwt.mongodb.models;

public class Location {
	private String posX;
	private String posY;
	private String route;
	private String city;
	private String country;
	public String getPosX() {
		return posX;
	}
	public void setPosX(String posX) {
		this.posX = posX;
	}
	public String getPosY() {
		return posY;
	}
	public void setPosY(String posY) {
		this.posY = posY;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
