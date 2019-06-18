package com.revature.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.services.ViewServiceImpl;

public class ViewServiceImplTest {
	
	private static ViewServiceImpl viewServiceImpl;

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

	/*
	 * @Test public void test() { fail("Not yet implemented"); }
	 */
	
	@Test
	public void testRetrieveMethod() {
		assertEquals("2020Tesla", viewServiceImpl.retrieve("1"), "Account ID #1 should be a Tesla");
	}

}
