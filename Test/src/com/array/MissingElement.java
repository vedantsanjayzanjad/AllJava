package com.array;

public class MissingElement 
{
	public static void main(String[] args) 
	{
		int arr [] = {1,2,3,4,6,7};
		for(int i =0;i<arr.length;i++)
		{
			if(arr[i] + 1 == arr[i+1])
			{
				continue;
			}
			System.out.println(arr[i] + 1);
			break;
		}
		
	}
}
