package com.personal.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.spring.entities.Order;
import com.personal.spring.entities.User;
import com.personal.spring.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}
	

}
