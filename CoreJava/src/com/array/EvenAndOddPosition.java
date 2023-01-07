package com.array;

public class EvenAndOddPosition 
{
	public static void main(String[] args) 
	{
		int arr [] = {12,234,56,35,63};
		
		for(int i = 0;i <arr.length;i++)
		{
			if(arr[i] % 2 == 0)
			{
				System.out.println("Position of the even element is " + i);
			}
			else
			{
				System.out.println("Position of the Odd element is " + i);
			}
			System.out.println("Next Elements ::");
		}
	}
}
