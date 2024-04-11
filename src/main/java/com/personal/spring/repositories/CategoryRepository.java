package com.personal.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.spring.entities.Category;

//@Repository - optional extends from JpaRepository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
