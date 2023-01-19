package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

interface inter {
	public String str(String str);
}

public class Practice {
	
	private static Practice pro;
	
	private Practice()
	{
		
	}
	
	public synchronized static Practice m1()
	{
		if(pro == null)
		{
			pro = new Practice();
		}
		return pro;
	}
	
//	public static void main(String[] args)
//	{
//		inter i = (str) ->
//		{
//			 String tr = str + str;
//			 return tr;
//		};
//		
//		System.out.println(i.str("Vedant"));
//	}
	public static boolean isPrime(int number) {
		if (number == 0 || number == 1) {
			System.out.println(number + " Not A Prime");
		}

		if (number == 2 || number == 3 || number == 5 || number == 7 || number == 9) {
			System.out.println(number + " A Prime");
		}
		if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0 || number % 7 == 0 || number % 9 == 0) {
			System.out.println(number + " Not A Prime");
		} else {
			System.out.println(number + " A Prime");
		}
		return true;

	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(22);
		list.add(32);
		list.add(31);
		list.add(31);
		list.add(34);
		list.add(12);

		List<String> str = new ArrayList<String>();
		str.add("vedant");
		str.add("Akshay");
		str.add("rushi");
		str.add("nihal");
		str.add("jaydip");

		// SUm
//	Integer integer = list.stream().reduce((a,b)->(a+b)).get();
//	System.out.println(integer);

		// ToArray
//	Integer [] arr = list.stream().toArray(Integer[]::new);
//	for(int i:arr)
//	{
//		System.out.println(i);
//	}

		// ascending
//		List<Integer> collect = list.stream().sorted((i1, i2) -> i1.compareTo(i2)).collect(Collectors.toList());
//		System.out.println(collect);
		// descening
//		List<Integer> collect = list.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList());
//		System.out.println(collect);

		// isPrime
//		List<Integer> collect = list.stream().filter(Practice::isPrime).collect(Collectors.toList());
//		System.out.println(collect);

		// maxandmin
//		Integer integer = list.stream().max((i1, i2) -> i1.compareTo(i2)).get();
//		System.out.println(integer);

		// map
//		List<Integer> collect = list.stream().filter(i -> i % 2==0).map(e->e * e).collect(Collectors.toList());
//		System.out.println(collect);

		// FlatMap
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(12);
//		list.add(22);
//		list.add(32);
//		list.add(31);
//		
//		List<Integer> listOne = new ArrayList<Integer>();
//		list.add(12);
//		list.add(22);
//		list.add(32);
//		list.add(31);
//		
//		List<Integer> listThree = new ArrayList<Integer>();
//		list.add(12);
//		list.add(22);
//		list.add(32);
//		list.add(31);
//		
//		List<List<Integer>> newList = new ArrayList<List<Integer>>();
//		newList.add(list);
//		newList.add(listOne);
//		newList.add(listThree);
//		
//		System.out.println(newList);
//		
//		List<Integer> collect = newList.stream().flatMap(n -> n.stream()).collect(Collectors.toList());
//		System.out.println(collect);

		// EvenOdd
//		List<Integer> collect = list.stream().filter(i -> i % 2==0).collect(Collectors.toList());
//		System.out.println(collect);

		// Duplicate
//		List<Integer> collect = list
//				.stream()
//				.filter(e ->Collections.frequency(list, e)>1)
//				.collect(Collectors.toList());
//		System.out.println(collect);

		// Distinct
//		List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
//		System.out.println(collect);

		// customize sorting
//		Comparator<String> sort = (i1, i2) -> {
//			int a = i1.length();
//			int b = i2.length();
//			if (a > b)
//				return 1;
//			else if (a < b)
//				return -1;
//			else
//				return i1.compareTo(i2);
//		};
//		List<String> collect = str.stream().sorted(sort).collect(Collectors.toList());
//		System.out.println(collect);
		
		//Singleton
//		
//		Practice ok = Practice.m1();
//		System.out.println(ok.hashCode());
//		
//		Practice on = Practice.m1();
//		System.out.println(on.hashCode());
		
		//reverse-number
		
		int num = 5678;
		int reverse = 0;
		System.out.println(num);
//		
//		StringBuilder stro = new StringBuilder(String.valueOf(num));
//		StringBuilder reverse = stro.reverse();
//		System.out.println(reverse);
		
//		StringBuffer ok = new StringBuffer();
//		StringBuffer append = ok.append(num);
//		StringBuffer reverse = append.reverse();
//		System.out.println(reverse);

//		for(;num!=0;num=num/10)
//		{
//			int rem = num % 10;
//		    reverse = reverse * 10 + rem;	
//		}
//		System.out.println(reverse);
		
		
		//reverseString
//		String ok = "Vedant";
//		String reverse1 ="";
//		StringBuffer stro = new StringBuffer(ok);
//		StringBuffer reverse2 = stro.reverse();
//		System.out.println(reverse2);
//		
//		for(int i = ok.length()-1;i>=0;i--)
//		{
//			 reverse1 = reverse1 + ok.charAt(i);
//		}
//		System.out.println(reverse1);
		
		
		//ArmStrongNumber
		
		//rem * rem * rem + rev
	}
}
