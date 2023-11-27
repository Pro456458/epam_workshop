package com.epam.workshop;

import java.util.ArrayList;

//Create add method of array list and provide alternative approach to add element in the mid of array
public class CustomArrayList {
	
	private static final String []DEFAULT_ELEMENT_DATA= {};
	private static final int DEFAULT_CAPACITY=5;
	private String[] element;
	private int size;
	
	public CustomArrayList() {
		super();
		this.element = DEFAULT_ELEMENT_DATA;
	}

	public static void main(String[] args) {
		
		ArrayList<String> arrayList=new ArrayList<>();
//		arrayList.add("A");
//		arrayList.add("B");
//		arrayList.add("C");
//		System.out.println(arrayList.toString());			//[A, B, C]
//		arrayList.add(1, "X");								//[A, X, B, C]
//		System.out.println(arrayList.toString());
		
		CustomArrayList customArrayList=new CustomArrayList();
		customArrayList.add("A");
		customArrayList.add("B");
		customArrayList.add("C");
		customArrayList.add("D");
		customArrayList.add("E");
		customArrayList.add("F");
		System.out.println(customArrayList.toString());
		customArrayList.add(3,"XXX");
		customArrayList.add(2,"YYY");
		customArrayList.add(10,"ZZZ");
		
		System.out.println(customArrayList.toString());
	}
	
	private boolean add(String value) {
		add(value,this.element,this.size);
		return true;
	}
	private boolean add(int index , String value) {
		
		if(!isCapasityAvailable(index))
			this.element=grow();
		
		swap(this.element,index,value);
		
		return true;
	}
	
	private void swap(String[] element, int index, String value) {
		
		if(index<size) {
			
			for(int i=size;i>=index;i--) {
				element[i]=element[i-1];
			}
			
			element[index]=value;
			this.size++;
			
		}else {
			element[index]=value;
			this.size++;
		}
		
	}

	private boolean isCapasityAvailable(int index) {
		if(index<0)
			throw new IllegalArgumentException("Illegal index: "+index);
		else if(this.size==this.element.length)
			return false;
		else if(index>this.size)
			return false;
		else if(index==size-1)
			return false;
		else
			return true;
	}
	
	private void add(String value, String[] object , int s) {
		if(s==this.element.length)
			this.element=grow();
		
		this.element[s]=value;
		size=s+1;
	}
	
	private String[] grow() {
		
		int oldCapacity=this.element.length;
		
		if(oldCapacity>0 && this.element!=DEFAULT_ELEMENT_DATA) {
			int newCapacity=getNewCapacity(oldCapacity);
		
			this.element=copyOf(element,newCapacity);
			
			return this.element;
		}else 
			return new String[DEFAULT_CAPACITY];
	}

	private String[] copyOf(String[] oldElement, int newCapacity) {
		
		String [] newElement=new String[newCapacity];
		
		for(int i=0;i<oldElement.length;i++) {
			newElement[i]=oldElement[i];
		}
		
		return newElement;
	}
	
	private int getNewCapacity(int oldCapacity) {
		return oldCapacity+(oldCapacity/2);
	}

	@Override
	public String toString() {
		
		StringBuilder sb=new StringBuilder();
		sb.append("CustomArrayList [element= ");
		for(int i=0;i<this.size;i++) {
				sb.append(this.element[i]+" ");
		}
		sb.append("]");
		
		
		return sb.toString();
		
	}
	
	
	

}
