package com.multiplesorting;

import java.util.*;
import java.util.stream.Collectors;

public class Salary {
	
	public static void main(String[] args) {
		
		List<Student>list = new ArrayList<Student>();
		list.add(new Student(1,"Vedant",233));
		list.add(new Student(2,"Akshay",234));
		list.add(new Student(3,"Ajit",2334));
		
		List <Student> ok = list.stream().filter(e-> e.salary > 3000).collect(Collectors.toList());
		System.out.println();
	}
}
