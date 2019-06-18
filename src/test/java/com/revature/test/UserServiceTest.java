package com.revature.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.services.UserService;
import com.revature.services.ViewServiceImpl;

public class UserServiceTest {
	
	private static UserService userService;	 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void nextCarIdSize() {
		assertEquals("1", userService.getNextCarID(), "ID should be 1 since lot unpopulated");
	}
}
