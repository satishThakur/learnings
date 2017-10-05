package com.satish.stream.application;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {
	
	
	public boolean isPrime(int N){
		return IntStream.rangeClosed(2, N/2)
				.noneMatch(num -> N % num == 0);
	}
	
	
	//Given number N (positive integer), partition the numbers in to prime and non prime.
	public Map<Boolean, List<Integer>> getPrimeNumbers(int N){		
		return IntStream.range(1, N).boxed().
				collect(Collectors.partitioningBy(this::isPrime));
	}
	
	public static void main(String[] args) {
		System.out.println(new PrimeNumbers().getPrimeNumbers(20));
	}

}
