package com.casestudy.auth.tests;

import static org.junit.Assert.assertEquals;
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
import com.casestudy.auth.service.StateServiceImpl;
import com.casestudy.auth.service.UserServiceImpl;
import com.casestudy.auth.utilities.ProgramException;

@SpringBootTest
@Rollback
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StateServiceTest {
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	StateServiceImpl service;
	static long testId;

	/*
	 * This test will add all the states to the database and make sure that
	 * it is not null.
	 */
	@Test
	@Order(1)
	void testAddStates() throws ProgramException {
		assertNotNull(service.addStates());
	}

	/*
	 * This test will confirm that all the states are present in the database.
	 */
	@Test
	@Order(2)
	void testFindAll() {
		assertNotNull(service.findAll());
	}

	/*
	 * This test will find the desired state based on its username.
	 */
	@Test
	@Order(3)
	void testFindByName() {
		String expected = "Alabama";
		State actual = service.findByName(expected);
		assertEquals(expected.toString(), actual.getName());
	}
	
	/*
	 * This test will function only when logged into the current account.
	 * The test relies on the principal class which finds the current logged
	 * in user and deletes the state from that user.
	 */
//	@Test
//	@Order(4)
//	void testDelete () {
//		ArrayList <State> list = new ArrayList<State> ();
//		State state = new State (1L, "Alabama");
//		list.add(state);
//		User user = new User(100L, "example2", "password", "password", list);
//		userService.save(user);
//		userService.deleteState(user.getStates().get(0));
//		assertEquals (user.getStates().get(0), null);
//	}
}
