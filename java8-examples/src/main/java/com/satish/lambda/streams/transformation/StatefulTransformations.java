package com.satish.lambda.streams.transformation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StatefulTransformations {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Mary", "Sally", "Mary", "Mary");
		
		//Distinct is stateful operation.
		names.stream().distinct().forEach(System.out::println);
		
		//Sort has to be stateful		
		List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());		
		System.out.println("Sorted Names: " + sortedNames);
		
		Optional<String> examle = Optional.of("sample");
		
		examle.ifPresent(System.out::println);
		examle.orElse("");
	}

}
