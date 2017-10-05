package com.satish.lambda.streams.transformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {
	
	public static void main(String[] args) {
		
		Function<String, Stream<Character>> mapper = s -> {
			List<Character> chars = new ArrayList<>();
			for(int i = 0; i < s.length(); i++){
				chars.add(s.charAt(i));
			}
			return chars.stream();
		};
		
		List<String> names = Arrays.asList("Sally", "John", "Smith");
		
		Stream<Stream<Character>> temp = names.stream().map(mapper);
		
		temp.forEach(s -> s.forEach(System.out::print));
		
		System.out.println();
		Stream<Character> charStream = names.stream().flatMap(mapper);
	}

}
