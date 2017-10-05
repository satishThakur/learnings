package com.satish.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaSyntax {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LambdaSyntax.class);

	/**
	 * Pre java 8
	 */

	public static void sortStrings(){
		List<String> names = Arrays.asList("John", "Smith", "Davidson", "Joe");

		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});		
		LOGGER.info("Sorted names: {}", names);		
	}
	
	//Lambda Expression which takes arguments.
	public static void sortStringsNew(){
		List<String> names = Arrays.asList("John", "Smith", "Davidson", "Joe");
		Collections.sort(names, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		LOGGER.info("Sorted names: {}", names);	
	}
	
	//Final answer, we will come back to this later do not panic.
	public static void sortStringFinal(){
		List<String> names = Arrays.asList("John", "Smith", "Davidson", "Joe");
		Collections.sort(names,Comparator.comparingInt(String::length));
		LOGGER.info("Sorted names: {}", names);	
	}
	
	//Lambda expression with no arguments
	
	public static void doWork() throws InterruptedException{
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(() ->{
			LOGGER.info("Doing some work..");
		});
		
		executorService.shutdown();
		executorService.awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) throws InterruptedException {
		sortStrings();
		sortStringsNew();
		sortStringFinal();
		doWork();
	}

}
