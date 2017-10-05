package com.satish.lambda.probs.wordcounter;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class WordCounter{

	private int count;
	private boolean isLastSpace;

	public WordCounter(int count, boolean isLastSpace){
		this.count = count;
		this.isLastSpace = isLastSpace;

	}

	public WordCounter acc(Character ch){
		if(Character.isWhitespace(ch)){
			return isLastSpace ? this : new WordCounter(count, true);
		}else{
			return isLastSpace ? new WordCounter(count + 1, false) : this;
		}
	}

	public WordCounter combine(WordCounter other){
		return new WordCounter(count + other.count, other.isLastSpace);
	}

	public int getCount(){
		return count;
	}

}

public class FunctionWordCounter {

	public static int getWordCounts(String s){
		Stream<Character> charStream = getCharStream(s);

		WordCounter wordCounter = charStream.reduce(
				new WordCounter(0, true), 
				WordCounter::acc, 
				WordCounter::combine);

		return wordCounter.getCount();
	}
	
	public static int getWordCountsParallel(String s){
		Stream<Character> charStream = getCharStream(s);
		
		WordCounter wordCounter = charStream.parallel().reduce(
				new WordCounter(0, true), 
				WordCounter::acc, 
				WordCounter::combine);

		return wordCounter.getCount();
	}
	
	private static Stream<Character> getCharStream(String s) {
		String cleanedString = s.trim();
		Stream<Character> charStream = IntStream.range(0, cleanedString.length())
				.mapToObj(i -> cleanedString.charAt(i));
		return charStream;
	}
	
	private static Stream<Character> getCharStreamNew(String s){
		String cleanedString = s.trim();
		Spliterator<Character> iterator = new WordCountSpliterator(cleanedString);
		return StreamSupport.stream(iterator, true);
	}

	public static void main(String[] args) {
		System.out.println(getWordCounts("   hello there     is   "));

		System.out.println(getWordCounts("hello   there     is"));
		
		System.out.println(getWordCountsParallel("   hello there     is   "));

		System.out.println(getWordCountsParallel("hello   there     is"));
	}

}
