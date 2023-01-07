package com.array;

public class Sum 
{
	public static void main(String[] args) 
	{
		int arr [] = {12,23,2,434};
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			sum = sum + arr[i];
		}
		System.err.println(sum);
	}
}
