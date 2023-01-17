package com.practice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Customer;
import com.practice.model.Orders;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	List<Customer> findByOrder(Orders order);

	List<Customer> findByCustNameContainingIgnoreCase(String custName);

	List<Customer> findByCustNameLike(String keyword);

//	 	public List<Student> findFirst3ByName(String name);
//		
//		public List<Student> findByNameIs(String name);
//		
//		public List<Student> findByNameEquals(String name);
//		
//		public List<Customer> findByRollNumber(String rollNumber);
//		
//		public List<Customer> findByUniversity(String university);
//		
//		public List<Customer> findByNameAndRollNumber(String name, String rollNumber);
//		
//		public List<Customer> findByRollNumberIn(List<String> rollNumbers);
//		
//		public List<Customer> findByRollNumberNotIn(List<String> rollNumbers);
//		
//		public List<Customer> findByRollNumberBetween(String start, String end);
//		
//		public List<Customer> findByNameNot(String name);
//		
//		public List<Customer> findByNameContainingIgnoreCase(String name);
//		
//		public List<Customer> findByNameLike(String name);
//		
//		public List<Customer> findByRollNumberGreaterThan(String rollnumber);
//		
//		public List<Customer> findByRollNumberLessThan(String rollnumber);

//	 User findFirstByOrderByLastnameAsc();

//	 User findTopByOrderByAgeDesc();

}
