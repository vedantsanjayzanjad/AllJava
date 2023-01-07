package com.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main 
{
	public static void main(String[] args)
	{
		ArrayList <Employee> l = new ArrayList<Employee>();
		l.add(new Employee("Vedant",1000));
		l.add(new Employee("Jay",1000));
		l.add(new Employee("Rushi",1000));
		l.add(new Employee("Harshit",1000));
		Predicate<Employee> p = e -> e.salary>3000;
		
		for(Employee e1 : l)
		{
			if(p.test(e1))
			{
				System.out.println(e1.name + ":" + e1.salary);
			}
		}
	}
}
