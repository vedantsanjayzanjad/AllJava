package com.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Customer;
import com.practice.model.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {

}
