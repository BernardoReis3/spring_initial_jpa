package com.personal.spring.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.personal.spring.entities.Category;
import com.personal.spring.entities.Order;
import com.personal.spring.entities.User;
import com.personal.spring.entities.enums.OrderStatus;
import com.personal.spring.repositories.CategoryRepository;
import com.personal.spring.repositories.OrderRepository;
import com.personal.spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), OrderStatus.DELIVERED ,u1); 
		Order o2 = new Order(null, Instant.parse("2023-07-21T03:42:10Z"), OrderStatus.CANCELLEED ,u2); 
		Order o3 = new Order(null, Instant.parse("2023-07-22T15:21:22Z"), OrderStatus.PAID ,u1);
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		
		List<User> users = new ArrayList<>();
		users.add(u1);
		users.add(u2);
		userRepository.saveAll(users);
		
		List<Order> orders = new ArrayList<>();
		orders.add(o1);
		orders.add(o2);
		orders.add(o3);
		orderRepository.saveAll(orders);
		
		List<Category> categories = new ArrayList<>();
		categories.add(cat1);
		categories.add(cat2);
		categories.add(cat3);
		categoryRepository.saveAll(categories);
	} 
}
