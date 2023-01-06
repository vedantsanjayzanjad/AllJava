package com.array;

import java.util.Arrays;

public class ArraysAreEqual 
{
	public static void main(String[] args)
	{
		int a [] = {12,22,232,4,3};
		int arr [] = {12,22,232,4,3};
		
//		boolean status = Arrays.equals(a, arr);
//		
//		if(status == true)
//		{
//			System.out.println("Are Equal");
//		}
//		else
//		{
//			System.out.println("Not Equal");
//		}
		
		boolean status = true;
		for(int i = 0 ; i < a.length;i++)
		{
			if(a.length == arr.length)
			{
				if(a[i] != arr[i])
				{
					status = false;
				}
			}
			else
			{
				status = false;
			}
		}
		
		if(status == true)
		{
			System.out.println("Are Equal");
		}
		else
		{
			System.out.println("Not Equals");
		}
	}
}
