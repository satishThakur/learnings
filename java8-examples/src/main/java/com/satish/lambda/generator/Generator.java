package com.satish.lambda.generator;

import java.util.function.Function;

public interface Generator<T> {
	
	public T generate();
	
	public default <U> Generator<U> map(Function<? super T, ? extends U> mapper){
		return () -> mapper.apply(this.generate());
		
	}
	
	public default <U> Generator<U> flatMap(Function<? super T, Generator<U>> mapper){
		return mapper.apply(this.generate());
	}

}
