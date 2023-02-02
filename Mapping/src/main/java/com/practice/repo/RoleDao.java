package com.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Role;

public interface RoleDao extends JpaRepository<Role, Integer> 
{

}
