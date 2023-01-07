package com.blog.reposistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>
{

}
