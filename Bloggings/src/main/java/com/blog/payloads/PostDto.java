package com.blog.payloads;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.model.Category;
import com.blog.model.Comment;
import com.blog.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private int postId;
	
	private String title;

	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comment = new HashSet<>();

}
