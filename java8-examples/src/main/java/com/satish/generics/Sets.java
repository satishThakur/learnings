package com.satish.generics;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Fruit{}

class Apple extends Fruit{}

class Orange extends Fruit{}


public class Sets {
	
	/**
	public static <T> Set<? extends T> unionWrong(Set<? extends T> s1, Set<? extends T> s2){		
		s1.addAll(s2);
		return s1;
	}
	**/
	
	/**
	 * Classic case of how covariants works for read. In languages like Scala you have support for covariant immutable collections.
	 * Not in java so we need to use the site variance.
	 * @param s1
	 * @param s2
	 * @return
	 */
	
	public static <T> Set<T> union(Set<? extends T> s1, Set<? extends T> s2){
		Set<T> union = new HashSet<>(s1);
		union.addAll(s2);
		return union;
	}
	
	/**
	 * Contra variant when we add the values. Which is mutability.
	 * @param first
	 * @param second
	 */
	public static <T> void addToFirst(Set<? super T> first, Set<T> second){
		first.addAll(second);
	}
	
	public static void main(String[] args) {
		Set<Apple> apples = Collections.singleton(new Apple());
		Set<Orange> oranges = Collections.singleton(new Orange());
		
		Set<Fruit> fruits = union(apples, oranges);
		
		addToFirst(new HashSet<>(),apples);
		
		fruits.forEach(f -> System.out.println(f.getClass().getName()));
	}

}
