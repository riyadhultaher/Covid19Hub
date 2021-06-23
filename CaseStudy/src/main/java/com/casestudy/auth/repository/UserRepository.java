package com.casestudy.auth.repository;

import com.casestudy.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * The UserRepository has just one abstract method
 * used to find an account by the username within
 * the database.
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
