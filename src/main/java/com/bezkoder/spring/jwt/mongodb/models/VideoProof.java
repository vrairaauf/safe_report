package com.bezkoder.spring.jwt.mongodb.models;

public class VideoProof extends Proof{
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public VideoProof(String id, Video video) {
		super(id);
		this.video = video;
	}
}
