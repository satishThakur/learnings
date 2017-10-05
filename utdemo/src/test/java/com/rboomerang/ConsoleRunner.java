package com.rboomerang;

import org.junit.internal.TextListener;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import com.rboomerang.fitnesstracker.DemoAssertionTest;

public class ConsoleRunner {
	
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.addListener(new RunListener(){
			@Override
			public void testRunFinished(Result result) throws Exception {
				System.out.println(result);
			}
			
			@Override
			public void testFinished(Description description) throws Exception {
				System.out.println(description);
			}
		});
		junit.run(DemoAssertionTest.class);
	}

}
