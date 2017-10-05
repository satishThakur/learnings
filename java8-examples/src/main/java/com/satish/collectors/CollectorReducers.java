package com.satish.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;

class MutableOptional<T>{
	private T value;

	public void setNewValue(T val){
		this.value = val;
	}

	public boolean isEmpty(){
		return value == null;
	}

	public T getValue(){
		return value;
	}

	public Optional<T> getOption(){
		return Optional.ofNullable(value);
	}
}

public class CollectorReducers {


	public static void main(String[] args) {

		List<String> cities = Arrays.asList("Delhi", "Bangalore", "Chennai", "Bhopal");

		//This is how we should do it.
		int totalChars = cities.stream()
				.collect(Collectors.summingInt(String::length));

		System.out.println(totalChars);

		//Fundamentally this is just a reduce.
		totalChars = cities.stream()
				.collect(Collectors.reducing(0, String::length, Integer::sum));

		//This is what it expands to
		totalChars = cities.stream()
				.collect(Collector.of(
						() -> new int[1], 
						(a,t) -> a[0] = a[0] + t.length(), 
						(a,b) -> {a[0] = a[0] + b[0]; return a;}, 
						a -> a[0], 
						new Characteristics[0]));

		System.out.println(totalChars);

		//Lets do one more example to understand it better.

		//This is how we should do it
		Optional<String> bigCity = cities.stream().collect(Collectors.maxBy(Comparator.comparing(String::length)));
		bigCity.ifPresent(System.out::println);


		//Lets do it using reduce
		Comparator<String> compreByLength = Comparator.comparing(String::length);

		bigCity = cities.stream()
				.collect(Collectors.reducing((s1,s2) -> {
					if(compreByLength.compare(s1, s2) > 0){
						return s1;
					}else{
						return s2;
					}

				}));
		bigCity.ifPresent(System.out::println);

		//Further we can simplify this

		bigCity = cities.stream()
				.collect(Collectors.reducing(BinaryOperator.maxBy(compreByLength)));
		bigCity.ifPresent(System.out::println);

		//Lets use the collector directly
		BinaryOperator<String> maxByOp = BinaryOperator.maxBy(compreByLength);

		bigCity = cities.stream()
				.collect(Collector.of(
						MutableOptional<String>::new, 
						(opt, str) -> {
							if(opt.isEmpty()){
								opt.setNewValue(str);
							}else{
								opt.setNewValue(maxByOp.apply(opt.getValue(), str));
							}
						}, 
						(opt1, opt2) -> {
							if(opt1.isEmpty()){
								return opt2;
							}
							if(opt2.isEmpty()){
								return opt1;
							}
							opt1.setNewValue(maxByOp.apply(opt1.getValue(), opt2.getValue()));
							return opt1;
						},
						t -> t.getOption(),
						new Characteristics[0]));

		bigCity.ifPresent(System.out::println);
		
		//Another way of doing it - 
		
		bigCity = cities.stream().reduce(maxByOp);
		bigCity.ifPresent(System.out::println);

	}

}
