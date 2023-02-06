package com.array;

public class SortingArray 
{
	public static void main(String[] args) 
	{
		int arr [] = {1,21,2,3,34,4,21};
		for(int i =0;i<arr.length;i++)
		{
			for(int j =i +1 ;j<arr.length;j++)
			{
				if(arr[i] < arr[j])
				{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				}
			}
			System.out.println("Sorting " + arr[i]);
		}
	}
}
