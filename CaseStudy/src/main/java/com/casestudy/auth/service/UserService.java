package com.casestudy.auth.service;

import com.casestudy.auth.model.State;
import com.casestudy.auth.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);

	void deleteState(State state);

	void update(User user);
}