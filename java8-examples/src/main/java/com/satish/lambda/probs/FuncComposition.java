package com.satish.lambda.probs;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FuncComposition {
	
	public static String apply(String s, UnaryOperator<String> op){
		return op.apply(s);
	}
	
	public static <U,T> List<U> map(List<T> l, Function<T, U> mapper){
		
		
		return null;
	}
	
	public static void main(String[] args) {
		UnaryOperator<String> toUpper = String::toUpperCase;
		
		String s = "  hello  ";
		
		Function<String, String> composed = toUpper.compose((String st) -> st.trim());
		//apply(s, composed);
	}

}
