package com.array.interview;

public class SortingArray 
{
	public static void main(String[] args) {
		
		int arr[] = {12,14,34,234};
		int temp=0;
		
		//Ascending
//		for(int i = 0; i < arr.length;i++)
//		{
//			for(int j = i + 1;j<arr.length;j++)
//			{
//				if(arr[i] > arr[j])
//				{
//					temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
//		for(int i1 = 0; i1< arr.length;i1++)
//		{
//			System.out.println(arr[i1]);
//		}
		
		//Descending
		for(int i = 0; i < arr.length;i++)
		{
			for(int j = i + 1;j<arr.length;j++)
			{
				if(arr[i] < arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i1 = 0; i1< arr.length;i1++)
		{
			System.out.println(arr[i1]);
		}
		
	}
}
