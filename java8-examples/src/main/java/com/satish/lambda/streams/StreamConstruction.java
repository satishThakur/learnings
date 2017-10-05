package com.satish.lambda.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamConstruction {
	
	public static void main(String[] args) throws IOException {
		
		//Stream from values.
		Stream<String> cities = Stream.of("Delhi", "Bangalore", "Chennai");
		
		//Collections have method for stream.
		List<Integer> numbers = Arrays.asList(2,5,7,8);
		Stream<Integer> numstreams = numbers.stream();
		
		
		//Infinite streams.
		Stream<Double> doubles = Stream.generate(Math::random);		
		doubles.limit(10).forEach(System.out::println);
		
		Stream<Integer> infiniteNums = Stream.iterate(0, x -> x +1);
		infiniteNums.limit(10).forEach(System.out::println);
		
		
		//Stream from File.
		
		try(Stream<String> lines = Files.lines(Paths.get("/Users/satish/tools/client.ovpn"))){
			lines.forEach(System.out::println);
		}
		
		
	}

}
