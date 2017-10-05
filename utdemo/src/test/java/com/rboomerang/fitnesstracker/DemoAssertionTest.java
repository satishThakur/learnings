package com.rboomerang.fitnesstracker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DemoAssertionTest {
	
	
	/**
	 * Same for assertFalse..
	 */
	@Test
	public void demoAssertTrue(){
		boolean result = true;
		
		assertTrue(result);
		
		assertThat(result, is(true));
	}
	
	@Test
	public void demoAssertNull(){
		Object result = null;
		
		assertNull(result);		
		assertThat(result, is(nullValue()));
	}
	
	@Test
	public void demoAssertNotNull(){
		Object result = new Object();
		
		assertNotNull(result);		
		assertThat(result, is(not(nullValue())));
	}
	
	
	
	@Test
	public void demoArrayAssertion(){
		String[] names = "John Harry Sunder".split(" ");
		
		assertArrayEquals(new String[]{"John", "Harry", "Sunder"}, names);
		
		assertThat(names, is(new String[]{"John", "Harry", "Sunder"}));
	}

}
