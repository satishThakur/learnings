package com.satish.lambda.probs.wordcounter;

public class WordCounterOld {

	public static int countWords(String s){
		int count = 0;
		s = s.trim();
		boolean isPreviousWhiteSpace = true;
		for(char ch : s.toCharArray()){
			if(Character.isWhitespace(ch)){
				isPreviousWhiteSpace = true;

			}else{
				if(isPreviousWhiteSpace){
					count++;
					isPreviousWhiteSpace = false;
				}
			}

		}		
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countWords("   hello there     is   "));

		System.out.println(countWords("hello   there     is"));
	}

}
