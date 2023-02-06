package com.array;

import java.util.Arrays;

public class EqualOrNot {
	public static void main(String[] args) {
		int arr[] = { 12, 23, 23, 4, 13, 3 };
		int arr1[] = { 12, 23, 23, 4, 13, 3 };
//		boolean status = Arrays.equals(arr, arr1);
//	
//		if(status == true)
//		{
//			System.out.println("Arrays Are Equals");
//		}

		boolean status = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr.length == arr1.length) {
				
				if(arr[i] == arr1[i])
				{
					status = true;
				}
			}
			else
			{
				status = false;
			}
			
		}
		if(status == true)
		{
			System.out.println("Equals");
		}
		
		else
		{
			System.out.println("NOt Equals");
		}
	}
}
