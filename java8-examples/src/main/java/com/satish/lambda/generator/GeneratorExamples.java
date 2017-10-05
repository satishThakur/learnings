package com.satish.lambda.generator;

import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

class Pair<T,U>{
    private T t;
    private U u;

    public Pair(T t, U u){
        this.t = t;
        this.u = u;
    }

    @Override
    public String toString() {
        return t + "," + u;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pair))
            return false;
        Pair<?, ?> other = (Pair<?, ?>)obj;
        return Objects.equals(t, other.t) && Objects.equals(u, other.t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, u);
    }
}


public class GeneratorExamples {
	
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		
		Generator<Integer> intGenerator = () -> rand.nextInt(100);
		
		Generator<Boolean> bools = intGenerator.map(i -> i % 2 == 0);
		
		Stream<Integer> infiniteInts = Stream.generate(intGenerator::generate);
		
		Stream<Boolean> infiniteBooleans = Stream.generate(bools::generate);
		
		infiniteInts.limit(10).forEach(System.out::println);
		infiniteBooleans.limit(10).forEach(System.out::println);
		
		
		Generator<Pair<Integer,Integer>> pairGenerator = 
				intGenerator.flatMap(i -> intGenerator.map(j -> new Pair<>(i, j)));
		
		
		Stream<Pair<Integer, Integer>> infinitePairs = 
				Stream.generate(pairGenerator::generate);
		infinitePairs.limit(20).forEach(System.out::println);
		
		
		pairGenerator = intGenerator.map(i -> new Pair<>(i, intGenerator.generate()));
		infinitePairs = Stream.generate(pairGenerator::generate);
		infinitePairs.limit(20).forEach(System.out::println);
	}

}
