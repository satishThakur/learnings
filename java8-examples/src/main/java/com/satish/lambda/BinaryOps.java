package com.satish.lambda;

import java.util.function.BinaryOperator;

public interface BinaryOps {
	
	public static <T>  T doBinaryOps(T first, T second, BinaryOperator<T> operator){
		return operator.apply(first, second);
	}
}

interface IntBinaryOps{
	
	public int sum(int a, int b);
	
	public int multiply(int a, int b);
}

class IntBinaryOpsIml implements IntBinaryOps{

	@Override
	public int sum(int a, int b) {
		return BinaryOps.doBinaryOps(a,b,Math::addExact);
	}

	@Override
	public int multiply(int a, int b) {
		return BinaryOps.doBinaryOps(a,b,Math::multiplyExact);
	}
	
}
