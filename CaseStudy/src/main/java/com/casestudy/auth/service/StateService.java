package com.casestudy.auth.service;

import java.util.List;

import com.casestudy.auth.model.State;

public interface StateService {

	List<String> addStates();

	void save(State state);

	List<State> findAll();

	State findByName(String name);

	void delete(State state);

	void assignHyperlink(State state);
}
