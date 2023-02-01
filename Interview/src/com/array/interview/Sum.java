package com.array.interview;

public class Sum 
{
	public static void main(String[] args) {
		
		int a[]={33,3,4,5};
		int sum =0;
		//for loop
//		for(int i = 0;i<a.length;i++)
//		{
//			sum = sum + a[i];
//		}
//		System.out.println(sum);
		
		//For each loop
		for(int i : a) {
			
			sum = sum + i;
		}
		
		System.out.println(sum);
	}
}
