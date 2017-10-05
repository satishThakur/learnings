package com.satish.lambda.probs;

import java.util.function.Function;

public class Pair<T> {
	
	private final T first;
	
	private final T second;
	
	public Pair(T first, T second){
		this.first = first;
		this.second = second;
	}
	
	
	public <U> Pair<U> map(Function<? super T, ? extends U> mapper){
		return new Pair<U>(mapper.apply(first), mapper.apply(second));
	}

}
