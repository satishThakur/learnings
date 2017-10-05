package com.satish.lambda.streams.transformation;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
	
	public static void main(String[] args) {
		
		IntStream nums = IntStream.of(1,4,7,10);
		
		//sum of all even
		int evenSum = nums.filter(n -> n%2 == 0).sum();
		System.out.println("All Even sum: " + evenSum);
		
		//get stream for array of ints.
		int[] numArray = {1,2,3,4,5,6,7,8,9};		
		Arrays.stream(numArray, 0, 5).forEach(System.out::println);
		
		//Range streams
		System.out.println(IntStream.range(0, 10).sum());
		System.out.println(IntStream.rangeClosed(0, 10).sum());
		
		//Object to primitive streams
		List<Person> persons = Person.getPersons();
		persons.stream().mapToInt(Person::getAge).sum();
		
		// primitive to Object 
		Stream<Integer> objStream = IntStream.of(1,4,7,10).boxed();
		
		 IntSummaryStatistics summaryStats = IntStream.of(1,4,7,10).summaryStatistics();
		 
		
	}

}
