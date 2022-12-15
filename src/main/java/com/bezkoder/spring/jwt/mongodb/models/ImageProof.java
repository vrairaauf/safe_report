package com.bezkoder.spring.jwt.mongodb.models;

public class ImageProof extends Proof{
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ImageProof(String id,Image image) {
		super(id);
		this.image = image;
	}
	
}
