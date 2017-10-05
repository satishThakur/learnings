package com.rboomerang;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUtLifecycle {
	
	private int counter;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before tests..");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("After tests..");
	}
	
	@Before
	public void onSetup(){
		System.out.println("On setup()");
	}
	
	@After
	public void onTearDown(){
		System.out.println("TearDown()");
		System.out.println("Counter: " + counter);
	}
	
	public TestUtLifecycle(){
		System.out.println("TestUtLifecycle");
	}
	
	
	@Test
	public void testMe(){
		System.out.println("testMe");
		counter++;
		
		assertTrue(true);
	}
	
	@Test
	public void testMeToo(){
		System.out.println("testMeToo");
		counter++;
		
		assertFalse(false);
	}

}
