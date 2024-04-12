package com.personal.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.spring.entities.Product;

//@Repository - optional extends from JpaRepository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
