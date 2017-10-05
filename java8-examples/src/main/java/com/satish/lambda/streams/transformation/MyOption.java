package com.satish.lambda.streams.transformation;

import java.util.function.Function;

public class MyOption<T> {
	
	private static MyOption<?> empty = new MyOption<>();
	
	private T val;
	
	private MyOption(){
		this.val = null;
	}
	
	private MyOption(T val){
		this.val = val;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> MyOption<T> empty(){
		return (MyOption<T>) empty;
	}
	
	public static <T> MyOption<T> of(T val){
		return new MyOption<T>(val);
	}
	
	public boolean isPresent(){
		return this != empty;
	}
	
	public <U> MyOption<U> map(Function<? super T, ? extends U> mapper){
		if(this.val == null){
			return empty();
		}
		U mapped = mapper.apply(val);
		if(mapped == null){
			return empty();
		}
		return new MyOption<U>(mapped);
		
	}
	
	public <U> MyOption<U> flatMap(Function<? super T, MyOption<U>> mapper){
		if(this.val == null){
			return empty();
		}
		return mapper.apply(val);
	}

}
