package com.bezkoder.spring.jwt.mongodb.models;

public class VoiceProof extends Proof{
	private Voice voice;

	public VoiceProof(String id, Voice voice) {
		super(id);
		this.voice = voice;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
}
