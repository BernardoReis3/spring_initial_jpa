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
import com.personal.spring.entities.OrderItem;
import com.personal.spring.entities.Payment;
import com.personal.spring.entities.Product;
import com.personal.spring.entities.User;
import com.personal.spring.entities.enums.OrderStatus;
import com.personal.spring.repositories.CategoryRepository;
import com.personal.spring.repositories.OrderItemRepository;
import com.personal.spring.repositories.OrderRepository;
import com.personal.spring.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
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
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
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
		
		List<Product> products = new ArrayList<>();		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		productRepository.saveAll(products);
		
		cat1.getProducts().add(p2);
		cat2.getProducts().add(p1);
		cat2.getProducts().add(p5);
		cat3.getProducts().add(p2);
		cat3.getProducts().add(p3);
		cat3.getProducts().add(p4);
		categoryRepository.saveAll(categories);
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		List<OrderItem> items = new ArrayList<>();
		items.add(oi1);
		items.add(oi2);
		items.add(oi3);
		items.add(oi4);
		orderItemRepository.saveAll(items);
		
		Payment payment1 = new Payment(null, Instant.parse("2023-07-22T17:21:22Z"), o3);
		o3.setPayment(payment1);
		
		orderRepository.save(o3);
		
	} 
}
