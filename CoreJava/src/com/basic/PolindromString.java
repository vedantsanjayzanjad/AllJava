package com.basic;

public class PolindromString {
	public static void main(String[] args) {

		String str = "madam";
		String rev = "";
		String temp = str; 
		
		for(int i = str.length() - 1 ; i >= 0;i--)
		{
			rev = rev + str.charAt(i);
		}
		//System.out.println(rev);
		
		if(rev.equals(temp))
		{
			System.out.println("Are");
		}
		else
		{
			System.out.println("Are Not");
		}
	}
}
