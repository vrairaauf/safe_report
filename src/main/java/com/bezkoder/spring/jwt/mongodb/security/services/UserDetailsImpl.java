package com.bezkoder.spring.jwt.mongodb.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bezkoder.spring.jwt.mongodb.models.Image;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	private boolean is_verify_account;
	private boolean complete_all_infos;
	private boolean has_profile_image;
	private Image image;
	
	public boolean isIs_verify_account() {
		return is_verify_account;
	}

	public void setIs_verify_account(boolean is_verify_account) {
		this.is_verify_account = is_verify_account;
	}

	public boolean isComplete_all_infos() {
		return complete_all_infos;
	}

	public void setComplete_all_infos(boolean complete_all_infos) {
		this.complete_all_infos = complete_all_infos;
	}

	public boolean isHas_profile_image() {
		return has_profile_image;
	}

	public void setHas_profile_image(boolean has_profile_image) {
		this.has_profile_image = has_profile_image;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDetailsImpl(String id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
