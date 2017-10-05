package com.satish.lambda.streams.transformation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class StreamReductions {
	
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Mary", "Sally", "Mary", "Mary");
		
		Optional<String> maxStr = names.stream().max(String::compareToIgnoreCase);
		
		//May not be best way to use.
		if(maxStr.isPresent()){
			System.out.println(maxStr.get());
		}
		
		//looks cleaner
		maxStr.ifPresent(System.out::println);
		
		
		//Actually the above one is compact form of fold:
		
		names.stream().reduce(BinaryOperator.maxBy(String::compareToIgnoreCase));
		
		//Further this could be expanded to:
		
		maxStr = names.stream().reduce((s1,s2) -> {
			if(s1.compareToIgnoreCase(s2) > 0){
				return s1;
			}else{
				return s2;
			}
		});
		
		maxStr.ifPresent(System.out::println);
	}

}
