package com.array;

public class CopyArray {
	public static void main(String[] args) {

		int arr[] = { 12, 2, 12, 11 };
		int arrOne[] = new int[arr.length];
		arrOne = arr;
		for (int i : arrOne) {
			System.out.println(i);
		}
	}
}
