package com.bezkoder.spring.jwt.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.jwt.mongodb.models.Notification;
import com.bezkoder.spring.jwt.mongodb.models.User;

public interface NotificationRepository extends MongoRepository<Notification, String> {
	Optional<Notification> findByUser(String user_id);
}
