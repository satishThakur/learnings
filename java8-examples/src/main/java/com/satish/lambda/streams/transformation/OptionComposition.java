package com.satish.lambda.streams.transformation;

import java.util.Optional;

public class OptionComposition {
	
	public static Optional<Double> inverse(double d){
		if(d == 0){
			return Optional.empty();
		}
		return Optional.of(1/d);
	}
	
	public static Optional<Double> sqrt(double d){
		if(d < 0){
			return Optional.empty();
		}
		return Optional.of(Math.sqrt(d));
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(inverse(3.4));
		System.out.println(inverse(0.0));
		
		inverse(5).flatMap(OptionComposition::sqrt);
		Optional.of(-3.0)
		.flatMap(OptionComposition::inverse)
		.flatMap(OptionComposition::sqrt);
		
	}

}
