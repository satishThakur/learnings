package com.satish.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Person{
	
	private String name;
	
	private int age;
	
	private int salary;
	
	public Person(String[] args){
		this.name = args[0].trim();
		
		this.age = Integer.parseInt(args[1].trim());
		
		this.salary = Integer.parseInt(args[2].trim());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
}

public class ConstructorRef {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConstructorRef.class);
	
	public static void demoConsRef(){
		List<String> rawValues = Arrays.asList("Steve,28,1000","Dave,32,1400");
		
		List<Person> persons = rawValues.stream().map(val -> {
			return val.split(",");
		})
		.map(Person::new)
		.collect(Collectors.toList());		
		
		persons.forEach(p -> LOGGER.info("Person: {}", p));
		
	}
	
	public static void main(String[] args) {
		demoConsRef();
	}

}
