package com.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

}
