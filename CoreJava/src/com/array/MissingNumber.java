package com.array;

public class MissingNumber
{
	public static void main(String[] args) 
	{
		int arr [] = {11,12,13,15,16};
		
		for(int i = 0 ; i < arr.length;i++)
		{
			if(arr[i] + 1 == arr[i+1])
			{
				continue;
			}
			
			int miss = arr[i] + 1;
			System.out.println(miss);
			break;
		}
		
	}
}
