package com.satish.lambda.streams.transformation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreamCollectors {

	public static void main(String[] args) {

		//Array collector.		
		String[] names = {"John", "Peter", "Philip", "Mark", "Philip", "Peter", "Zacota"};

		String[] shortNames = Arrays.stream(names)
				.filter(s -> s.length() < 5)
				.toArray(String[]::new);
		System.out.println(Arrays.toString(shortNames));

		
		//reducer to collect data. What is wrong with this??
		Set<String> longNamesSet = Arrays.stream(names)
				.filter(s -> s.length() > 5)
				.reduce(new HashSet<String>(), 
						(se,s) -> {
							se.add(s); 
							return se;
						}, 
						(s1,s2) -> {
							s1.addAll(s2);
							return s1;
						});
		
		System.out.println(longNamesSet);
		
		//Use collector
		longNamesSet = Arrays.stream(names)
		.filter(s -> s.length() > 4)
		.collect(HashSet::new, HashSet::add, HashSet::addAll);
		
		System.out.println(longNamesSet);
		
		//Use helper methods
		longNamesSet = Arrays.stream(names)
				.filter(s -> s.length() > 4)
				.collect(Collectors.toSet());
		System.out.println(longNamesSet);
		
		//Use specialized Set
		longNamesSet = Arrays.stream(names)
				.filter(s -> s.length() > 4)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(longNamesSet);
		
		//String concat
		//What is wrong with this? Would this work in parallel? 
		Arrays.stream(names).reduce("",String::concat);
		
		//What is the difference?
		Arrays.stream(names).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		
		
		//String joining
		
		String allNames = Arrays.stream(names).collect(Collectors.joining(" | "));
		System.out.println(allNames);
		
		
		
	}

}
