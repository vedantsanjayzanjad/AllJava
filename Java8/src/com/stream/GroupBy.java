package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee
{
	private int empId;
	private String empName;
	private String empCity;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	
	public Employee(int empId, String empName, String empCity) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empCity = empCity;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empCity=" + empCity + "]";
	}
	
	
	
}



public class GroupBy 
{
	public static void main(String[] args) 
	{
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1,"Vedant","Pune"));
		list.add(new Employee(2,"AKshay","Pune"));
		list.add(new Employee(3,"Rushikesh","Amravati"));
		list.add(new Employee(4,"Nobody","Nanded"));
		
		//1
//		List<Employee> collect = list.stream().filter(e -> e.getEmpCity() == "Pune").collect(Collectors.toList());
//		System.out.println(collect);
		

		//2
//	  Map<String, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee :: getEmpCity));
//	  System.out.println(collect);
	  
		//3
//	  Map<String, Long> collectCount = list.stream().collect(Collectors.groupingBy(Employee :: getEmpCity,Collectors.counting()));
//	  System.out.println(collectCount);
	}
}
