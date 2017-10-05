package com.satish.java8.datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

//Instant is what date used to be. Point in time on time axis.
public class InstantExample {
	
	public static void main(String[] args) {
		Instant instant = Instant.now();
		
		
		IntStream.rangeClosed(0, 10_000_000)
		.forEach(x -> {});
		
		Duration duration = Duration.between(instant, Instant.now());
		
		System.out.println(duration.toMillis());
	}

}
