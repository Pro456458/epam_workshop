package com.epam.workshop;

import java.util.Arrays;
import java.util.Random;

/*write a program to swap array of elements randomly*/
public class SwapArrayElementRandomly {

	public static void main(String[] args) {
		
		int inputArray[] =new int[] {1,2,3,4,5,6,7,8,9};
		
		System.out.println("==========INPUT ARRAY=========");
		System.out.println(Arrays.toString( inputArray ));
		
		SwapArrayElementRandomly swap=new SwapArrayElementRandomly();
		
		System.out.println("==========OUTPUT ARRAY=========");
		System.out.println(Arrays.toString( swap.swapElementRandomly(inputArray) ));

	}
	
	private int[] swapElementRandomly(int[] inputArray) {
		Random random=new Random();
		
		int n=inputArray.length;
		int temp=0;
		
		for(int i=0;i<n;i++) {
			int randomI=random.nextInt(n-i);
			temp=inputArray[i];
			inputArray[i]=inputArray[randomI];
			inputArray[randomI]=temp;
		}
		
		return inputArray;
		
	}
	

}
