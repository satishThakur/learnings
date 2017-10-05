package com.satish.lambda.probs.wordcounter;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCountSpliterator implements Spliterator<Character>{

	private String s;

	private int currentIndex = 0;

	public WordCountSpliterator(String s){
		this.s = s;

	}

	@Override
	public boolean tryAdvance(Consumer<? super Character> action) {
		if(currentIndex < s.length()){
			action.accept(s.charAt(currentIndex));
			currentIndex++;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Spliterator<Character> trySplit() {
		int currentSize = s.length() - currentIndex;
		if(currentSize < 10){
			return null;
		}else{
			for(int index = currentSize/2 + currentIndex; index < s.length(); index++){
				if(Character.isWhitespace(s.charAt(index))){

					WordCountSpliterator splitIt = new WordCountSpliterator(s.substring(currentIndex, index));
					currentIndex = index;
					return splitIt;
				}
			}
		}
		return null;
	}

	@Override
	public long estimateSize() {
		return s.length() - currentIndex;
	}

	@Override
	public int characteristics() {
		return ORDERED + SIZED + IMMUTABLE + SUBSIZED + NONNULL;
	}
}
