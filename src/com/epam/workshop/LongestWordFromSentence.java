package com.epam.workshop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Given a sentence find the word that has the highest length.*/
public class LongestWordFromSentence {

	public static void main(String[] args) {
		
		String output;
		String input = "I am interested123455 to grow in my organization";
		
		System.out.println("Input : "+ input);
		LongestWordFromSentence longestWord=new LongestWordFromSentence();

		System.out.println("===========================================");
		System.out.println("*****Given a sentence find the word that has the highest length********");
		System.out.println("===========================================");
		
		output=longestWord.findLongestWordFromSentance_01(input);
		System.out.println( "output Using 1st Approach : "+ output);
		
		output=longestWord.findLongestWordFromSentance_02(input);
		System.out.println("output Using 2nd Approach : "+output);
		
		
		output=longestWord.findLongestWordFromSentance_03(input);
		System.out.println("output Using 3rd Approach : "+output);
		
		
		System.out.println("===========================================");
		System.out.println("*****Given a sentence find the 2nd/Nth longest Word********");
		System.out.println("===========================================");
		
		
		output=longestWord.findNthLongestWordFromSentance(input,2);
		System.out.println("output : "+output);

		System.out.println("===========================================");
		System.out.println("*****Given a sentence find the length of the longest Word********");
		System.out.println("===========================================");
		
		
		int length=longestWord.findTheLengthOfLongestWordFromSentance(input);
		System.out.println("output : "+length);
		
		System.out.println("===========================================");
		System.out.println("*****Given a sentence Find the 2nd highest length word in the given sentence********");
		System.out.println("===========================================");
		
		
		length=longestWord.findTheLengthOfNthLongestWordFromSentance(input,2);
		System.out.println("output : "+length);

		
		System.out.println("===========================================");
		System.out.println("*****Given a sentence find the word and its length in descending order********");
		System.out.println("===========================================");
		
		
		Map<Object, Object> outputMap=longestWord.findTheWordWithItsLengthFromSentance(input);
		longestWord.printValueFromMap(outputMap);
		
		
	}



	private Map<Object, Object> findTheWordWithItsLengthFromSentance(String input) {
		return Arrays.stream(input.split(" "))
				.collect( Collectors.groupingBy(
							value -> value , Collectors.summingInt(value -> value.length()) 
						)).entrySet().stream().
							sorted( (o1, o2) -> o2.getValue() - o1.getValue() )
								.collect(Collectors.
										toMap(Map.Entry::getKey, Map.Entry::getValue ,
												(oldValue, newValue) -> oldValue, LinkedHashMap::new ));
		
	}

	private void printValueFromMap(Map<Object, Object> outputMap) {
		outputMap.forEach( (K, V) -> System.out.println( K+" : " +V) );
	}


	private int findTheLengthOfLongestWordFromSentance(String input) {
		return Arrays.stream(input.split(" ")).mapToInt( value -> value.length() ).max().getAsInt();
	}
	
	private int findTheLengthOfNthLongestWordFromSentance(String input,int i) {
		return Arrays.stream(input.split(" ")).map( value -> value.length() ).sorted(Comparator.reverseOrder())
				.skip(i-1).findFirst().get();
	}	

	private String findLongestWordFromSentance_01(String input) {
		return Stream.of(input.split(" ")).max( Comparator.comparingInt( str ->  str.length() ) ).get();
	}
	
	private String findLongestWordFromSentance_02(String input) {
		return Arrays.stream(input.split(" ")).max( Comparator.comparingInt( str ->  str.length() ) ).get();
	}
	
	private String findLongestWordFromSentance_03(String input) {
		return Stream.of(input.split(" ")).sorted( Comparator.comparingInt(String::length).reversed()).findFirst().get();
	}
	
	private String findNthLongestWordFromSentance(String input, int i) {
		return Stream.of(input.split(" ")).sorted( (o1, o2) -> o2.length()-o1.length()  ).skip(i-1).findFirst().get();
	}

	

}
