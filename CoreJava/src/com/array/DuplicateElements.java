package com.array;

public class DuplicateElements 
{
	public static void main(String[] args) 
	{
		int arr [] = {12,1343,234,23,12};
		for(int i = 0; i < arr.length;i++)
		{
			for(int j = i + 1; j < arr.length;j++)
			if(arr[i] == arr[j])
				{
					System.out.println("Duplicates Elements in array " + arr[i]);
				}

		}
	}
}
