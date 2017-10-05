package com.satish.lambda.probs;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Triplet<T>{
	private T t;
	private T u;
	private T r;

	public Triplet(T t, T u, T r){
		this.t = t;
		this.u = u;
		this.r = r;
	}

	@Override
	public String toString() {
		return t.toString() + "," + u.toString() + "," + r.toString();
	}
}

public class PythagoreanTriples {

	public static void main(String[] args) {

		Stream<Triplet<Integer>> pythagorianTriplets = 
				IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.range(a, 100).boxed()
						.flatMap(b -> IntStream.range(b, 100).boxed()
								.filter(c -> a * a + b * b == c * c)
								.map(c -> new Triplet<>(a,b,c))
								));

		pythagorianTriplets.forEach(System.out::println);
	}

}
