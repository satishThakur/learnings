package com.satish.lambda.funsets;

import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface IntSet {
	
	public boolean isMember(int x);
	
	public default boolean contains(int elem){
		return isMember(elem);
	}
	
	public static IntSet singletonSet(int elem){
		return x -> elem == x;
	}
	
	public default IntSet union(IntSet s){
		return x -> contains(x) || s.contains(x);
	}
	
	public default IntSet intersection(IntSet s){
		return x -> contains(x) && s.contains(x);
	}

	public default IntSet diff(IntSet s){
		return x -> contains(x) && (!s.contains(x));
	}

	public default IntSet filter(IntPredicate p){
		return x -> contains(x) && p.test(x);
	}
	
	public default boolean forAll(IntPredicate p){
		return IntStream.rangeClosed(-1000, 1000)
				.filter(x -> contains(x))
				.allMatch(p);
	}
	
	public default boolean exisits(IntPredicate p){
		return !forAll(x -> !p.test(x));
	}
	
	public default IntSet map(ToIntFunction<Integer> mapper){
		return x -> exisits(y -> mapper.applyAsInt(y) == x);
	}
	
	public default String makeString(){
		return IntStream.rangeClosed(-1000, 1000)
		.filter(x -> contains(x))
		.mapToObj(String::valueOf)
		.collect(Collectors.joining(",", "{", "}"));
	}
}
