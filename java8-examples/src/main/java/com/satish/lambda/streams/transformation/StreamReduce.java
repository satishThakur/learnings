package com.satish.lambda.streams.transformation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduce {

	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(2,45,7);
		
		//First form of reduction
		Optional<Integer> sum = nums.stream().reduce(Math::addExact);
		System.out.println(sum);
		
		//second form with identity
		int sumNum = nums.stream().reduce(0, Math::addExact);
		System.out.println(sumNum);
		
		List<String> words = Arrays.asList("test", "machine", "program", "define");
		
		//third form with accumulator
		int allWordsLength = words.stream()
				.reduce(0, (num,str) -> num + str.length(), Integer::sum);
		System.out.println(allWordsLength);
		
		//better way would still be:
		System.out.println(words.stream().mapToInt(String::length).sum());
	}
}
