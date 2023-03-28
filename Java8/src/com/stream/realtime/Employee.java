package com.stream.realtime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.stream.Map;

class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// How Many Male And Females Are There
		System.out.println("First");
		java.util.Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(noOfMaleAndFemaleEmployees);

		System.out.println("Second");
		// How Many Departments Are Here
		List<String> collect = employeeList.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
		System.out.println(collect);

		System.out.println("Third");
		// What is the average age of male and female employees?
		java.util.Map<String, Double> collect2 = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println(collect2);

		System.out.println("Four");
		// Get the names of all employees who have joined after 2015?
		List<String> collect3 = employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println(collect3);
		
		

		System.out.println("Fifth");
//		Count the number of employees in each department?
		java.util.Map<String, Long> employeeCountByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(employeeCountByDepartment);

		System.out.println("Six");
		// avg salary of dept
		java.util.Map<String, Double> avgSalaryOfDepartments = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalaryOfDepartments);

		System.out.println("Seven");
		// Get the details of youngest male employee in the product development
		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper = employeeList.stream()
				.filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getAge));
		System.out.println(youngestMaleEmployeeInProductDevelopmentWrapper);

		Optional<Employee> min = employeeList.stream()
				.filter(e -> e.gender == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getAge));
		System.out.println(min);

		System.out.println("Eight");
		// Who has the most working experience in the organization?
//		Optional<Employee> seniorMostEmployeeWrapper = employeeList.stream()
//				.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
//
//		Employee seniorMostEmployee = seniorMostEmployeeWrapper.get();
//
//		System.out.println(seniorMostEmployee);	
		Employee employee = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
		System.out.println(employee);

		System.out.println("Nine");
		// How many male and female employees are there in the sales and marketing team?
		java.util.Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
				.filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(countMaleFemaleEmployeesInSalesMarketing);
		System.out.println("Ten");

		// What is the average salary of male and female employees?
		java.util.Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avgSalaryOfMaleAndFemaleEmployees);

		//ByDepartmentALlTheEmployee
		java.util.Map<String, List<Employee>> employeeListByDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> entrySet = employeeListByDepartment.entrySet();

		for (Entry<String, List<Employee>> entry : entrySet) {
			System.out.println("--------------------------------------");

			System.out.println("Employees In " + entry.getKey() + " : ");

			System.out.println("--------------------------------------");

			List<Employee> list = entry.getValue();

			for (Employee e : list) {
				System.out.println(e.getName());
			}
		}
		
//		Set<String> keySet = employeeListByDepartment.keySet();
//		Iterator<String> iterator = keySet.iterator();
//		while(iterator.hasNext())
//		{
//			String next = iterator.next();
//			System.out.println(next);
//			List<Employee> list = employeeListByDepartment.get(next);
//			for(Employee e : list)
//			{
//				System.out.println(e.getName());
//			}
//		}

		System.out.println("Eleven");
		// What is the average salary and total salary of the whole organization?
//		For this query, we use Collectors.summarizingDouble()on Employee::getSalary 
//		which will return statistics of the employee salary like max, min, average and total.

		DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());

		System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());

		System.out.println("Twelve");

		// Get the details of highest paid employee in the organization?
		// Use Collectors.maxBy() method which returns maximum element wrapped in an
		// Optional
		// object based on supplied Comparator.

//		Optional<Employee> highestPaidEmployeeWrapper = employeeList.stream()
//				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
//		System.out.println(highestPaidEmployeeWrapper);
//				Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
//				         
//				System.out.println("Details Of Highest Paid Employee : ");
//				         
//				System.out.println("==================================");
//				         
//				System.out.println("ID : "+highestPaidEmployee.getId());
//				         
//				System.out.println("Name : "+highestPaidEmployee.getName());
//				         
//				System.out.println("Age : "+highestPaidEmployee.getAge());
//				         
//				System.out.println("Gender : "+highestPaidEmployee.getGender());
//				         
//				System.out.println("Department : "+highestPaidEmployee.getDepartment());
//				         
//				System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());
//				         
//				System.out.println("Salary : "+highestPaidEmployee.getSalary());
		
		Employee employee2 = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println(employee2);

		System.out.println("Thirteen");

//	Who is the oldest employee in the organization? What is his age and which department he belongs to?
		Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));

		Employee oldestEmployee = oldestEmployeeWrapper.get();

		System.out.println("Name : " + oldestEmployee.getName());

		System.out.println("Age : " + oldestEmployee.getAge());

		System.out.println("Department : " + oldestEmployee.getDepartment());
		
				
	}
}
