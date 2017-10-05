package com.satish.lambda.probs.medaltally;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MedalTally {
	
	public static void main(String[] args) {
		String[] stats = {
				"Pakistan,0,0,0", 
				"GBR,27,23,17", 
				"USA,46,37,38", 
				"Egypt,0,0,3", 
				"China,26,18,26", 
				"Russia,19,18,19", 
				"India,0,1,1"
		};
		
		List<CountryTally> conuntrystandings = Stream.of(stats)
				.map(CountryTally::new)
				.collect(Collectors.toList());
		
		conuntrystandings.sort(Comparator.comparing(CountryTally::getGold)
				.thenComparing(CountryTally::getSilver)
				.thenComparing(CountryTally::getBronze)
				.thenComparing(CountryTally::getCountry)
				.reversed());
		
		conuntrystandings.forEach(System.out::println);
	}
}
