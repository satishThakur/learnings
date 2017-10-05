package com.satish.generators;

import java.util.Random;

public class IntGenerator implements Generator<Integer>{
	
	private int maxBound ;
	
	public IntGenerator(int maxBound){
		this.maxBound = maxBound;
	}
	
	@Override
	public Integer getNext() {
		Random rand = new Random(37);
		return rand.nextInt(maxBound);
	}

}
