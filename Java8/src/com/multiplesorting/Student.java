package com.multiplesorting;

public class Student {
	
	Integer id;
	String name;
	Integer salary;
	
	public Student(Integer id, String name, int i) {
		super();
		this.id = id;
		this.name = name;
		this.salary = i;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}


	
	
}
