package com.casestudy.auth.service;

import java.util.List;

import com.casestudy.auth.model.State;
import com.casestudy.auth.utilities.ProgramException;

/*
 * This DAO interface defines several methods when it
 * comes to full CRUD functionality related to user states.
 * This includes initially adding states to the database,
 * finding a specific state, and deleting a state. This
 * also assigns hyperlinks to the respective state. This
 * interface is defined in the State Service Implementation
 * class.
 */
public interface StateService {

	List<String> addStates() throws ProgramException;

	void save(State state);

	List<State> findAll();

	State findByName(String name);

	void delete(State state);

	void assignHyperlink(State state);
}
