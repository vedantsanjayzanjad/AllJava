package com.array;

public class SortingArray
{
	public static void main(String[] args) 
	{
		int arr [] = {123,13,23,34,45};
		
		for(int i = 0; i <arr.length;i++)
		{
			for(int j = i + 1; j< arr.length;j++)
			{
				if(arr[i] < arr[j])
				{
					int temp = 0;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println("Descneding order " + arr[i]);
		}
		
		
//		for(int i = 0; i <arr.length;i++)
//		{
//			for(int j = i + 1; j< arr.length;j++)
//			{
//				if(arr[i] > arr[j])
//				{
//					int temp = 0;
//					temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				}
//			}
//			System.out.println("Ascending order " + arr[i]);
//		}
	}
}
