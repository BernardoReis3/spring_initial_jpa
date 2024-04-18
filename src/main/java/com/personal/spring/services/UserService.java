package com.personal.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.personal.spring.entities.User;
import com.personal.spring.repositories.UserRepository;
import com.personal.spring.services.exceptions.DatabaseException;
import com.personal.spring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Integer id) {
		try {
			userRepository.deleteById(id);
		} 
		catch (EmptyResultDataAccessException erdae) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException dive) {
			throw new DatabaseException(dive.getMessage());
		}
	}
	
	public User update(Integer id, User user) {
		try {
			User u = userRepository.getReferenceById(id);
			updateData(u, user);
			return userRepository.save(u);
		}catch (EntityNotFoundException enfe) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User u, User user) {
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPhone(user.getPhone());
	}
	

}
