package com.bezkoder.spring.jwt.mongodb.payload.response;

import java.util.List;

import com.bezkoder.spring.jwt.mongodb.models.Image;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String id;
	private String username;
	private String email;
	private List<String> roles;
	
	
	private boolean is_verified=false;
	private boolean has_profile_image=false;
	private boolean complete_all_etaps_of_signup=false;
	private Image profile_image;
	

	public boolean isIs_verified() {
		return is_verified;
	}

	public void setIs_verified(boolean is_verified) {
		this.is_verified = is_verified;
	}

	public boolean isHas_profile_image() {
		return has_profile_image;
	}

	public void setHas_profile_image(boolean has_profile_image) {
		this.has_profile_image = has_profile_image;
	}

	public boolean isComplete_all_etaps_of_signup() {
		return complete_all_etaps_of_signup;
	}

	public void setComplete_all_etaps_of_signup(boolean complete_all_etaps_of_signup) {
		this.complete_all_etaps_of_signup = complete_all_etaps_of_signup;
	}

	public Image getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(Image profile_image) {
		this.profile_image = profile_image;
	}

	public JwtResponse(String accessToken, String id, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
