package com.multiplesorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1,"Vedant",233));
		list.add(new Student(2,"Akshay",234));
		list.add(new Student(3,"Ajit",2334));
		
		
		//byName
		Comparator<Student> std = (std1,std2) -> std1.name.compareTo(std2.getName());
		Object byName = list.stream().sorted(std).collect(Collectors.toList());
		System.out.println(byName);
		
		//byId
		Comparator<Student> byId = (id1,id2)->id1.getId().compareTo(id2.getId());
		Object collect = list.stream().sorted(byId).collect(Collectors.toList());
		System.out.println(collect);
		
		//All
		
		Object yes = list.stream().sorted(std.thenComparing(byId)).collect(Collectors.toList());
		System.out.println(yes);
		
	}
}
