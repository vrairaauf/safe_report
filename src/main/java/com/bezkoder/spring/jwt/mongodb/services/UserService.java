package com.bezkoder.spring.jwt.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public com.bezkoder.spring.jwt.mongodb.models.User findUserByUsername(String username) {
		Optional<com.bezkoder.spring.jwt.mongodb.models.User> user=userRepository.findByUsername(username);
		if(!user.isEmpty()) {
			return user.get();
		}
		return null;
	}
	
	public com.bezkoder.spring.jwt.mongodb.models.User updateUser(String id, com.bezkoder.spring.jwt.mongodb.models.User user){
		Optional<com.bezkoder.spring.jwt.mongodb.models.User> findUser=userRepository.findById(id);
		if(!findUser.isEmpty()) {
			userRepository.save(user);
		}
		return user;
	}
	public List<com.bezkoder.spring.jwt.mongodb.models.User> findAll(){
		return userRepository.findAll();
	}
	
	public Optional<com.bezkoder.spring.jwt.mongodb.models.User> retrieve_user(String id){
		return userRepository.findById(id);
	}
}
