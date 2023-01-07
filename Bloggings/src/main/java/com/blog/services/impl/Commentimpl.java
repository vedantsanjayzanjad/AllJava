package com.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exceptions.ResourceNotFoundException;
import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.payloads.CommentDto;
import com.blog.reposistories.CommentDao;
import com.blog.reposistories.PostDao;
import com.blog.services.CommentService;

@Service
public class Commentimpl implements CommentService{

	@Autowired
	private CommentDao commentdao;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto,Integer postId) {
	Post post = this.postDao.findById(postId).orElseThrow(() ->new  ResourceNotFoundException("post","id",postId));
	Comment comment = this.modelMapper.map(commentDto, Comment.class);
	comment.setPost(post);
	
	Comment saveCooment = this.commentdao.save(comment);
	return this.modelMapper.map(saveCooment,CommentDto.class);
	}


	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = 
		this.commentdao.findById(commentId).orElseThrow(() ->new  ResourceNotFoundException("comment","id",commentId));
		this.commentdao.delete(comment);
		
	}

}
