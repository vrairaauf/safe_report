package com.bezkoder.spring.jwt.mongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jwt.mongodb.models.Notification;
import com.bezkoder.spring.jwt.mongodb.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	public void save(Notification notification){
		notificationRepository.save(notification);
	}
	public ResponseEntity<?> get_all_notification_per_user(String id){
		return ResponseEntity.ok(notificationRepository.findByUser(id));
	}
	public ResponseEntity<?> all(){
		return ResponseEntity.ok(notificationRepository.findAll());
	}
}
