package com.satish.lambda.streams.transformation;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("something", "small", "hat", "price", "boomerang", "etc");
		
		int count = 0;
		
		for(String word : words){
			if(word.length() < 4){
				count++;
				count--;
				count++;
			}
		}
		
		long shortWordsCount = words.stream()
				.filter(w -> w.length() < 4)
				.count();
		System.out.println(shortWordsCount);
	}

}
