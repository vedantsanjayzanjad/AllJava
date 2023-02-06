package com.array;

public class SecondMax 
{
	public static void main(String[] args) 
	{
		int arr [] = {1,21,2,3,34,4,32};	
		int max = arr[0];
		int secondMax = arr[0];
		for(int i : arr)
		{
			if(i > max)
			{
				max = i;
			}
		}
		System.out.println(max);
		
		for(int i : arr)
		{
			if(i < max && i > secondMax)
			{
				secondMax = i;
			}
		}
		System.out.println(secondMax);
		
	}
}
