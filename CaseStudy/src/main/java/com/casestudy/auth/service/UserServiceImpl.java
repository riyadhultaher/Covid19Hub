package com.casestudy.auth.service;

import com.casestudy.auth.model.User;
import com.casestudy.auth.model.State;
import com.casestudy.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * This class implements the StateService DAO
 * interface. The user repository and Bcrypt are
 * autowired into the class.
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/*
	 * This method is used strictly when creating an account
	 * or changing a password.
	 */
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	/*
	 * This method is used when persisting a state to a user's account.
	 * Since it does not have the Bcrypt encoder, the password will not
	 * be affected.
	 */
	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	/*
	 * This method finds a specific user based on their
	 * username.
	 */
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	/*
	 * This method is built on top of the delete method from
	 * the state service. It will delete a state from the specifically
	 * logged in user.
	 */
	@Transactional
	public void deleteState(State state) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<State> listStates = null;

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			User user = findByUsername(username);
			listStates = user.getStates();
		}
		
		listStates.remove(state);
	}

	@Override
	public void delete(User user) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = findByUsername(username);
		}
		userRepository.delete(user);
	}
}