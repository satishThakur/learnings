package com.satish.lambda.streams.transformation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Alice", "JOHN", "mONTY");
		
		List<String> lowercaseNames = names.stream()
				.parallel()
				.map(String::toLowerCase)
				.collect(Collectors.toList());
		System.out.println(lowercaseNames);
	}

}
