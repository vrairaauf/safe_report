package com.bezkoder.spring.jwt.mongodb.models;

public class LocationProof extends Proof{
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public LocationProof(String id, Location location) {
		super(id);
		this.location = location;
	}
	
}
