package com.epam.workshop;

//Remove duplicates from string and return in same order".
public class RemoveDuplicateFromString {

	public static void main(String[] args) {

		String input = "dabfcadef"; 		// excepted output-> dabfce
		System.out.println("Input String :"+ input);
		RemoveDuplicateFromString remove=new RemoveDuplicateFromString();
		
		String output=remove.removeDuplicateFromString(input);
		System.out.println("Output String :"+ output);
		
	}

	private String removeDuplicateFromString(String input) {
		return input.chars().mapToObj(value -> (char) value).distinct().toString();
	}

}
