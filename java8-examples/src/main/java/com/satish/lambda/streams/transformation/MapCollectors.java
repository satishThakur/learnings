package com.satish.lambda.streams.transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapCollectors {
	
	
	
	public static void main(String[] args) {
		List<Person> persons = Person.getPersons();
		
		//Map collector with key and value extractors.
		Map<Long, Person> idToPersonMap = persons.stream()
				.collect(Collectors.toMap(Person::getId, Function.identity()));
		System.out.println(idToPersonMap);
		
		
		//Key value extractors + merger functions.
		Map<Integer, List<Person>> ageToPersons = persons.stream().collect(Collectors.toMap(Person::getAge, Collections::singletonList, (list1, list2) -> {
			List<Person> merged = new ArrayList<>(list1);
			merged.addAll(list2);
			return merged;
		}));
		
		System.out.println(ageToPersons);
		
		//Define specific map as well
		ageToPersons = persons.stream().collect(Collectors.toMap(Person::getAge, Collections::singletonList, (list1, list2) -> {
			List<Person> merged = new ArrayList<>(list1);
			merged.addAll(list2);
			return merged;
		}, TreeMap::new));
		
		ageToPersons.forEach((age, ps) -> {
			System.out.println(age + " : " + ps);
		});
		
		
	}

}
