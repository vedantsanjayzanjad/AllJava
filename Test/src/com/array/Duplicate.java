package com.array;

import java.util.HashSet;
import java.util.Set;

public class Duplicate {
	public static void main(String[] args) {
		int arr[] = { 1, 21, 2, 3, 34, 4, 21 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.println(arr[i]);
				}
			}
		}

		int[] array = { 1, 1, 2, 3, 4, 5, 6, 7, 8, 8 };

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < array.length; i++) {
			// If same integer is already present then add method will return FALSE
			if (set.add(array[i]) == false) {
				System.out.println("Duplicate element found : " + array[i]);
			}
		}
	}
}
