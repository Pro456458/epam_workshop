package com.epam.workshop;

import java.util.Arrays;

public class Adding2Array {

	public static void main(String[] args) {
		
		int a[] =new int[] {1,2,3};			//{1,2,3} , {1,2,3}  add =246
		int b[] =new int[] {1,2,3};			//{9,9} , {9}        add=108
		
		
		System.out.println("Input Array One : "+Arrays.toString(a));
		System.out.println("Input Array Two : "+Arrays.toString(a));
		System.out.println("===========Output=============");
		System.out.println( converIntArrIntoInt(a) + converIntArrIntoInt(b) );
		
		
			
	}

	private static int converIntArrIntoInt(int[] intArray) {
		
		StringBuilder sb=new StringBuilder(); 
		
		for (int i = 0; i < intArray.length; i++) {
			sb.append(intArray[i]);
		}
		
		return Integer.parseInt(sb.toString());
		
	}
}