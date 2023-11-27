package com.epam.workshop;

import java.util.Arrays;

//Write a method to sort a array, that contains only 0 and 1//
//int a[]= {0,1,0,1,1,1,0,0};
public class SortArrayContainsZeroAndOneOnly {

	public static void main(String[] args) {
		
		int inputArray_1[]= {0,1,0,1,1,1,0,0,1,1};
		
		System.out.println("Input Array 1");
		System.out.println(Arrays.toString(inputArray_1));
		
		SortArrayContainsZeroAndOneOnly sortArray=new SortArrayContainsZeroAndOneOnly();
		System.out.println("============Output with 1st Approach with (OrderOf_NLogN) Complexity===============");
		System.out.println(Arrays.toString( sortArray.sortArray_With_OrderOf_NLogN(inputArray_1) ));
	
		
		System.out.println("===================================================");
		
		
		int[] inputArray_2={0,1,0,1,1,1,0,0,1,1};
		System.out.println("Input Array 2");
		System.out.println(Arrays.toString(inputArray_2));
		System.out.println("============Output with 2nd Approach with (OrderOf_N) Complexity===============");
		System.out.println(Arrays.toString(sortArray.sortArray_With_OrderOf_N(inputArray_2)));
		
	}
	
	/* time complexity O(N log N) */
	private int[] sortArray_With_OrderOf_NLogN(int inputArray[]) {
		
		int index=0;
		int length=inputArray.length;
		for(int i=0;i<length;i++) {
			
			if( inputArray[i]!=0) {
				inputArray[i]=0;
				index++;
			}
			
		}
		
		while(index>0) {
			inputArray[length-index]=1;
			index--;
		}
		
		return inputArray;
		
	}
	
	
	/* time complexity O(N) */
	public int[] sortArray_With_OrderOf_N(int[] inputArray){
        int count=0;int length=inputArray.length;
        for(int i=0;i<length;i++){
            if(inputArray[i]!=1){
                swap(count,i,inputArray);
                count++;
            }
        }

        return inputArray;
    }

    private static void swap(int count, int i, int[] inputArray) {

        int temp=inputArray[count];
        inputArray[count]=inputArray[i];
        inputArray[i]=temp;
    }
}

