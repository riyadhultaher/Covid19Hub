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

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

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
}