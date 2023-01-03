package com.bezkoder.spring.jwt.mongodb.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  
  private String phone;
  private String cin;
  private String region;
  private String postalcode;
  private String address;
  @NotBlank
  @Size(max = 120)
  private String password;
  
  @DBRef
  private Set<Role> roles = new HashSet<>();
  
  private boolean is_verified;
  private boolean has_profile_image;
  private boolean complete_all_etaps_of_signup;
  private Image profile_image;
  private String verify_code;
  
  private List<Corruption> corruptions=new ArrayList<Corruption>();
  
  public List<Corruption> getCorruptions() {
	return corruptions;
}



public void setCorruptions(List<Corruption> corruptions) {
	this.corruptions = corruptions;
}

public void addOneCorruption(Corruption corruption) {
	this.corruptions.add(corruption);
}


public String getVerify_code() {
	return verify_code;
}



public void setVerify_code(String verify_code) {
	this.verify_code = verify_code;
}



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



public User() {
  }

  

  public String getPhone() {
	return phone;
}



public void setPhone(String phone) {
	this.phone = phone;
}



public String getCin() {
	return cin;
}



public void setCin(String cin) {
	this.cin = cin;
}



public String getRegion() {
	return region;
}



public void setRegion(String region) {
	this.region = region;
}



public String getPostalcode() {
	return postalcode;
}



public void setPostalcode(String postalcode) {
	this.postalcode = postalcode;
}



public String getAddress() {
	return address;
}



public void setAddress(String address) {
	this.address = address;
}



public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
		String phone, String cin, String region, String postalcode, String address,
		@NotBlank @Size(max = 120) String password) {
	super();
	
	this.username = username;
	this.email = email;
	this.phone = phone;
	this.cin = cin;
	this.region = region;
	this.postalcode = postalcode;
	this.address = address;
	this.password = password;
}



public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
