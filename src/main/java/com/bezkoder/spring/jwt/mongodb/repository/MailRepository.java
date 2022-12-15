package com.bezkoder.spring.jwt.mongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.bezkoder.spring.jwt.mongodb.models.Role;
import com.bezkoder.spring.jwt.mongodb.models.Verify_Code;

public interface MailRepository extends MongoRepository<Verify_Code, String> {
	Boolean existsByMail(String mail);
	Boolean existsByCode(String code);
	Optional<Verify_Code> findByMail(String mail);

}
