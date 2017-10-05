package com.satish.lambda.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaClosure {
	
	public static void example(){
		String[] names = {"Peter", "Harry", "Sunny"};
		List<Runnable> rs = new ArrayList<>();
		for(String name: names){
			rs.add(() -> System.out.println(name));
		}
		rs.forEach(r -> r.run());
	}
	
	public static void example1(){
		String[] names = {"Peter", "Harry", "Sunny"};
		List<Runnable> rs = new ArrayList<>();
		for(int i = 0; i < names.length; i++){
			
			//rs.add(() -> System.out.println(names[i]));
		}
		rs.forEach(r -> r.run());
	}
	
	//Puzzle!!
	public static void example2(){
		String[] names = {"Peter", "Harry", "Sunny"};
		List<Runnable> rs = new ArrayList<>();
		AtomicInteger i = new AtomicInteger(0);
		while(i.get() < names.length){
			rs.add(() -> System.out.println(names[i.get()]));
			i.incrementAndGet();
		}
		rs.forEach(r -> r.run());
	}
	
	//puzzle!!
	public static void example3(){
		String[] names = {"Peter", "Harry", "Sunny"};
		List<Runnable> rs = new ArrayList<>();
		AtomicInteger i = new AtomicInteger(0);
		while(true){
			rs.add(() -> System.out.println(names[i.get()]));
			if(i.get() == 2){
				break;
			}else{
				i.incrementAndGet();
			}			
		}
		rs.forEach(r -> r.run());
	}
	
	

	public static void main(String[] args) {
		/*String[] names = {"Peter", "Harry", "Sunny"};
		
		Function<String, Runnable> func = s -> () -> System.out.println(s);
		
		// http://stackoverflow.com/questions/26872827/java-lambda-returning-a-lambda
		//Arrays.stream(names).map(name -> System.out::println);
		
		List<Runnable> rs = Arrays.stream(names).map(func).collect(Collectors.toList());
		
		rs.forEach(r -> r.run());*/
		
		//example2();
		example2();
	}
}
