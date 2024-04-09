package com.personal.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.personal.spring.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
