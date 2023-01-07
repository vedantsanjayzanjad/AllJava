package com.predicate;

import java.util.function.Predicate;

public class First 
{
	public static void main(String[] args) {
		
		String [] s = {"Vedant","Akshay","bhai","Letsee"};
		Predicate<String> k = a -> a.length() > 5;
		for(String a : s)
		{
			if(k.test(a))
			{
				System.out.println(a);
			}
		}
	}
}
