package com.array.interview;

import java.util.Scanner;

public class RemoveDuplicateElements 
{
	public static void main(String[] args) {
		
	
	int n ;
	int count = 0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter The Number Of Elements You Want To Add"); 
	n = sc.nextInt();
	int [] arr = new int[n];
	System.out.println("Enter The Elements");
	for(int i = 0; i<n;i++)
	{
		arr[i] = sc.nextInt();
	}
	System.out.println("");
	
	//Logic For To Remove The Duplicates
	for(int i = 0; i < n; i++)
	{
		for(int j = i + 1 ; j < n; j++ )
		{
			if(arr[i] == arr[j])
			{
				System.out.println("Duplicates Elements Are :" + arr[i]);
				arr[j] = arr[n - 1];
				n--;
			}
		}
	}
	System.out.println("New Array Without Repeatations");
	for(int i = 0; i < n; i++)
	{
		System.out.println(arr[i]);
	}
	
}
}
