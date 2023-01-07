package com.blog.services;

import java.util.List;

import com.blog.model.Post;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;


public interface PostService {

	PostDto creatpost(PostDto postDto,Integer categoryId,Integer userId);

	PostDto updatePost(PostDto posDto, Integer postId);

	void deletePost(Integer postId);

	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy);

	PostDto getOnePost(Integer postId);

	List<PostDto> getPostsByCategory(Integer categoryId);

	List<PostDto> getPostsByUser(Integer userId);
	
	List<PostDto> serachByTitle(String keyword);

}
