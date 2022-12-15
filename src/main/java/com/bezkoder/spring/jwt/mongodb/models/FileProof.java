package com.bezkoder.spring.jwt.mongodb.models;

public class FileProof extends Proof{
	private FileR file;

	public FileR getFile() {
		return file;
	}

	public void setFile(FileR file) {
		this.file = file;
	}

	public FileProof(String id, FileR file) {
		super(id);
		this.file = file;
	}
	
}
