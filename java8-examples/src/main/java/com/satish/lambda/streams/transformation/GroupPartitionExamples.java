package com.satish.lambda.streams.transformation;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupPartitionExamples {
	
	public static <T,U> void pairPrinter(T t, U u){
		System.out.println(t.toString() + ": " + u.toString());
		
	}
	
	public static void main(String[] args) {
		
		List<Person> persons = Person.getPersons();
		
		Map<Integer, List<Person>> groupByAge = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		
		groupByAge.forEach(GroupPartitionExamples::pairPrinter);
		
		//Find Max age per city.		
		Map<String, Optional<Person>> maxAge = persons.stream().collect(
				Collectors.groupingBy(Person::getCity, 
						Collectors.maxBy(Comparator.comparing(Person::getAge))));
		
		maxAge.forEach(GroupPartitionExamples::pairPrinter);
		
		//Get me all names from a city	
		Map<String, Set<String>> cityNames = persons.stream().collect(
				Collectors.groupingBy(Person::getCity,
				Collectors.mapping(Person::getName,Collectors.toSet() )));
		
		cityNames.forEach(GroupPartitionExamples::pairPrinter);
		
		// I dont know what i want but it is possible :). Ok we want to see name lengths
		Map<String, Set<Integer>> mystery = persons.stream().collect(
				Collectors.groupingBy(Person::getCity,
				Collectors.mapping(Person::getName,
						Collectors.mapping(
								String::length, Collectors.toSet()
								) )));
		
		mystery.forEach(GroupPartitionExamples::pairPrinter);
		
		//Lets try reduction.
		
		Map<String, String> cityAllNames = persons.stream().collect(
				Collectors.groupingBy(Person::getCity, 
						Collectors.reducing("", Person::getName, 
								(s,t) -> s.length() == 0 ? t : s + "," + t)));
		
		cityAllNames.forEach(GroupPartitionExamples::pairPrinter);
		
		//There is better way		
		cityAllNames = persons.stream().collect(
					Collectors.groupingBy(Person::getCity, 
							Collectors.mapping( Person::getName, 
									Collectors.joining(","))));
		cityAllNames.forEach(GroupPartitionExamples::pairPrinter);
	}

}
