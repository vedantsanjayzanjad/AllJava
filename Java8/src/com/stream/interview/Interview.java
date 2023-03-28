package com.stream.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.predicate.Employee;
import com.stream.Distinct;

class Customer {
	private int cust_id;
	private String cust_name;
	private String city;
	private int age;

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer(int cust_id, String cust_name, String city, int age) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.city = city;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", city=" + city + ", age=" + age + "]";
	}

	public interface Interview {

		private static List<Customer> getUnSortedCustomers() {

			List<Customer> cust = new ArrayList<>();
			cust.add(new Customer(1, "Vedant", "Pune", 12));
			cust.add(new Customer(2, "Vedant", "Pune", 22));
			cust.add(new Customer(3, "AKshay", "Pune", 32));
			cust.add(new Customer(4, "Hrushiksh", "Pune", 52));
			cust.add(new Customer(5, "rushi", "Pune", 26));
			cust.add(new Customer(1, "abhya", "Pune", 29));
			return cust;
		}
		
		public static void main(String[] args) 
		{
			List<Customer> list = getUnSortedCustomers();		
			System.out.println(list);
			Set<Customer> collect = list
		                .stream() // get stream for original list
		                .collect(Collectors.toCollection(//distinct elements stored into new SET
		                    () -> new TreeSet<>(Comparator.comparing(Customer::getCust_name)))
		                        ); 
			System.out.println(collect);	
		}
	}

}
