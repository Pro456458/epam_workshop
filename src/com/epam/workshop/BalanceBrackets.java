package com.epam.workshop;

import java.util.Stack;

public class BalanceBrackets {

	public static void main(String[] args) {
		String expr = "([{}])";
		//String expr ="Hello[()]{}world{[()()]()}";
		//String expr ="Hello[(])";
		
		if(areBalanceBrackets(expr))
			System.out.println("Balance");
		else
			System.out.println("Not Balance");

	}

	private static boolean areBalanceBrackets(String expr) {
		
		Stack<Character> stack=new Stack<Character>();
		
		for(int i=0;i<expr.length();i++) {
			char ch=expr.charAt(i);

			if(ch=='{' || ch=='[' || ch=='(') {
				stack.push(ch);
				continue;
			}
			
			
			char check;
			
			switch(ch) {
				case ')':
					check=stack.pop();
					if( check=='{' || check=='[')
						return false;
						break;
				case '}':
					check=stack.pop();
					if(check=='[' || check=='(')
						return false;
						break;					
				case ']':
					check=stack.pop();
					if( check=='{' || check=='(')
						return false;
						break;
					
			}
			
		}
		
		return stack.isEmpty();
	}
}