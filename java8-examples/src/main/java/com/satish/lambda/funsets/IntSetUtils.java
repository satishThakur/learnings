package com.satish.lambda.funsets;

public class IntSetUtils {
	
	public static void main(String[] args) {
		// {1,2,3,4}
		IntSet s1 = x -> x > 0 && x < 5;		
		System.out.println(s1.makeString());
		
		// {4,5,6}
		IntSet s2 = x -> x > 3 && x < 7;
		
		System.out.println(s1.union(s2).makeString());
		
		System.out.println(s1.intersection(s2).makeString());
		
		System.out.println(s1.diff(s2).makeString());
		
		IntSet s3 = s1.map(x -> x * x);
		System.out.println(s3.makeString());
		
	}

}
