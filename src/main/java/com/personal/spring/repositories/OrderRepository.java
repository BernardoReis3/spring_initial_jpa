package com.personal.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.spring.entities.Order;

//@Repository - optional extends from JpaRepository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
