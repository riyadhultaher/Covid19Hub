package com.casestudy.auth.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.casestudy.auth.model.State;
import com.casestudy.auth.service.StateServiceImpl;

@SpringBootTest
@Rollback
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StateServiceTest {
	@Autowired
	StateServiceImpl service;
	static long testId;

	@Test
	@Order(1)
	void testAddStates() {
		assertNotNull(service.addStates());
	}

	@Test
	@Order(2)
	void testFindAll() {
		assertNotNull(service.findAll());
	}

	@Test
	@Order(3)
	void testFindByName() {
		String expected = "Alabama";
		State actual = service.findByName(expected);
		assertEquals(expected.toString(), actual.getName());
	}
}
