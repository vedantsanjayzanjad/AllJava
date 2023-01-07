package com.blog.reposistories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {

	
}
