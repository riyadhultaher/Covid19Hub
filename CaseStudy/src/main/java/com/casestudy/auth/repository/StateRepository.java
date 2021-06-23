package com.casestudy.auth.repository;

import com.casestudy.auth.model.State;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * The StateRepository class has just one
 * abstract methods that finds a state model
 * based on its name from the database.
 */
public interface StateRepository extends JpaRepository<State, Long> {
	State findByName(String name);
}
