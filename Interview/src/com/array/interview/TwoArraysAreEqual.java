package com.array.interview;

import java.util.Arrays;

public class TwoArraysAreEqual 
{
	public static void main(String[] args) {
		
		int a [] = {1,243,56,2};
		int arr [] = {1,23,56,2};
		
		//First Way
//		boolean status = Arrays.equals(a, arr);
//		if(status == true)
//		{
//			System.out.println("Are Equals");
//		}
//		else 
//		{
//			System.out.println("Not Equals");
//		}
		
		//Second Way
		boolean status = true;
		if(a.length == arr.length)
		{
			for(int i = 0; i < a.length;i++)
			{
				if(a[i] != arr[i])
				{
					status = false;
				}
			}
		}
		else
		{
			status = false;
		}
		
		if(status == true)
		{
			System.out.println("Arryas Are Equals");
		}
		else
		{
			System.out.println("Not Equals");
		}
	}
}
