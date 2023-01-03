package com.bezkoder.spring.jwt.mongodb.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jwt.mongodb.models.Notification;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.services.NotificationService;


@RestController
@RequestMapping("safecorruption/api/v1/user/notification/")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping("new/notification")
	public ResponseEntity<?> ucreate_notification(@RequestBody Notification notification) {
		notification.setDate(new Date());
		notificationService.save(notification);
		return ResponseEntity.ok("notification created successfully");
	}
	
	@GetMapping("all/{id}")
	public ResponseEntity all_notification_per_user(@PathVariable String id) {
		return ResponseEntity.ok(notificationService.get_all_notification_per_user(id));
	}
	@GetMapping("all")
	
	public ResponseEntity<?> all_notifications(){
		return notificationService.all();
	}
	

}
