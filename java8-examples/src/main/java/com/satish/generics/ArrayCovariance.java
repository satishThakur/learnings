package com.satish.generics;

import java.util.Arrays;
import java.util.List;

public class ArrayCovariance {
	
	public static void main(String[] args) {
		
		Apple[] apples = new Apple[]{new Apple()};
		
		Fruit[] fruits = apples;
		
		fruits[0] = new Orange();
		
		Apple apple = apples[0];
		
		System.out.println(apple.getClass().getName());
		
		
		//Try same thing with list.
		
		List<Apple> applesList = Arrays.asList(new Apple()); 
		
		//List<Fruit> fruitsList = applesList;
	}

}
