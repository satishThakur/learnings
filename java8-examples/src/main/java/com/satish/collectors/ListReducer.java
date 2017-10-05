package com.satish.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListReducer {
	
	public static void main(String[] args) {
		 Stream<List<String>> s = Stream.of(
	                Arrays.asList("hi", "bye"),
	                Arrays.asList("yes", "no"),
	                Arrays.asList("true", "false"));
		 
		  Stream<String> strings = s.flatMap(l -> l.stream());
		  
		  System.out.println(strings.collect(Collectors.joining(" | ","[ "," ]")));
	}

}
