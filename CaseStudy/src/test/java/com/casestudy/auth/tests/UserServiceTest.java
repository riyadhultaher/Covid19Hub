package com.casestudy.auth.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.casestudy.auth.model.State;
import com.casestudy.auth.model.User;
import com.casestudy.auth.service.UserServiceImpl;

@SpringBootTest
@Rollback
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {
	@Autowired
	UserServiceImpl service;
	static long testId;
	
	/*
	 * This test will test that a user is created and
	 * saved into the database.
	 */
	@Test
	@Order (1)
	void testSave () {
		ArrayList <State> list = new ArrayList<State> ();
		User user = new User(100L, "example", "password", "password", list);
		service.save(user);
		testId = user.getId();
		assertNotNull(user.getId());
	}
	
	/*
	 * This test will find the desired user based on its username.
	 */
	@Test
	@Order (2)
	void testFindByUsername () {
		String expected = "example";
		User user = service.findByUsername("example");
		assertEquals(expected.toString(), user.getUsername());
	}
}
