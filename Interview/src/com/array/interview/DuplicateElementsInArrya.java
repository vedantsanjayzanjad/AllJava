package com.array.interview;

public class DuplicateElementsInArrya {
	public static void main(String[] args) {
		
		int arr[] = {12,12,34,45};
		for(int i = 0; i < arr.length;i++)
		{
			for(int j = i +1 ; j < arr.length;j++)
			{
				if(arr[i] == arr[j])
				{
					System.out.println("Duplicate Elements Are :: " + arr[i]);
				}				
			}
		}
	}
}
