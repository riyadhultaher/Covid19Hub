package com.casestudy.auth.service;

import com.casestudy.auth.model.State;
import com.casestudy.auth.model.User;

/*
 * This class defines abstract methods to save a
 * user in the database and find a specific user.
 * The delete state method is built on top of the delete
 * method from the state service class which allows
 * the state to be deleted from that specific user.
 * The update method is used strictly to change a user's
 * password. These methods are implemented in the user
 * service implementation class.
 */
public interface UserService {
	void save(User user);

	User findByUsername(String username);

	void deleteState(State state);

	void update(User user);
	
	void delete(User user);
}