package com.personal.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.spring.entities.OrderItem;
import com.personal.spring.entities.primaryKey.OrderItemPK;

//@Repository - optional extends from JpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
