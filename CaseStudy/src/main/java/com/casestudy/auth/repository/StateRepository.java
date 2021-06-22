package com.casestudy.auth.repository;

import com.casestudy.auth.model.State;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
	State findByName(String name);
}
