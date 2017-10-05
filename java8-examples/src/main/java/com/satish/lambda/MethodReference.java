package com.satish.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Method reference is much more compact way and better way to reuse. 
 * Not sure if analogy is correct but this is pretty much like:
 * if (something) return true; else return false; --> return something
 * @author satish
 *
 */
public class MethodReference {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodReference.class);
	
	//Case 1: Static method.
	//See Other class called BinaryOps
	
	
	//case 2: instance method --> referenced through object.
	public static void sortStringFinal(){
		List<String> names = Arrays.asList("John", "Smith", "Davidson", "Joe");
		
		Collections.sort(names, Comparator.comparingInt((name -> name.length())));
		Collections.sort(names,Comparator.comparingInt(String::length));
		LOGGER.info("Sorted names: {}", names);	
	}
	
	
	//case 3: instance method --> referenced through class
	public static void printAllNames(){
		List<String> names = Arrays.asList("Dev", "John", "Steve", "Philip");
		
		//using lambda
		names.forEach(name -> LOGGER.info(name));
		
		//replacing lambda with method reference.
		names.forEach(LOGGER::info);
	}
	
	//Constructor ref
	
	public static void demoConstRef(){
		List<String> names = Arrays.asList("Dev", "John", "Steve", "Philip");
		List<Thread> threads = names.stream().map(Thread::new).collect(Collectors.toList());
		threads.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		//printAllNames();
		demoConstRef();
	}

}
