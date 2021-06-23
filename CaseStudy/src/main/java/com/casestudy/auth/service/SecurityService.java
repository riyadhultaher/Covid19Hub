package com.casestudy.auth.service;

/*
 * This DAO interface defines two methods
 * to find the logged in user and to auto login
 * a user using Spring security. These methods
 * are implemented in the Security Service
 * Implementation class.
 */
public interface SecurityService {
	String findLoggedInUsername();

	void autoLogin(String username, String password);
}