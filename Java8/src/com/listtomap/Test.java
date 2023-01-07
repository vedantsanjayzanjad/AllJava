package com.listtomap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test 
{
	private int empId;
	private String empName;
	private String empSalary;
	
	public Test(int empId,String empName,String empSalary)
	{
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		
	}
	
	@Override
	public String toString() {
		return "Test [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
	
	
	public static void main(String[] args) 
	{
		List<Test> std = new ArrayList<>();
		std.add(new Test(1, "Vedant", "4000"));
		std.add(new Test(2, "jaydip", "3000"));
		std.add(new Test(3, "rushikesh", "6322"));
		
		System.out.println(std);
		
//		Map<Integer, String> collect = std.stream().collect(Collectors.toMap(e->e.empId, e->e.empName));
//		System.out.println(collect);
		
		
		Map<Integer,String> output = std.stream().filter(emp-> emp.empSalary != "3000").collect(Collectors.toMap(a-> a.empId, a->a.empName));
		System.out.println(output);
	}

}