package com.personal.spring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.spring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> getUser(){
		User user = new User(2, "Alberto", "alberto@gmail.com", "911111111", "hello");
		return ResponseEntity.ok().body(user);
	}

}
