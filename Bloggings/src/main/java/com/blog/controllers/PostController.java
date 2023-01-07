package com.blog.controllers;
import java.io.IOException;


import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.config.AppConstant;
import com.blog.model.Post;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.services.FileService;
import com.blog.services.PostService;

//import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> creatPost
	(@RequestBody PostDto postDto,
	@PathVariable Integer categoryId,
	@PathVariable Integer userId)
	{
		PostDto savedPostDto = this.postService.creatpost(postDto,categoryId, userId);
		return new ResponseEntity<PostDto>(savedPostDto,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/users/{userId}/posts")
	public ResponseEntity<List<PostDto>> getByUser(@RequestBody PostDto postDto,
			@PathVariable Integer userId)
	{
		List<PostDto> savedPostDto = this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(savedPostDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getByCategory(@RequestBody PostDto postDto,
			@PathVariable Integer categoryId)
	{
		List<PostDto> savedPostDto = this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(savedPostDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<PostResponse> getAllPosts(
	@RequestParam(value = "pageNumber",defaultValue = AppConstant.PAGE_NUMBER_STRING,required = false)Integer pageNumber,
	@RequestParam(value = "pageSize",defaultValue = AppConstant.PAGE_SIZE_STRING,required = false)Integer pageSize,		
	@RequestParam(value = "sortBy",defaultValue = AppConstant.SORTBY_STRING,required = false)String sortBy		
	)
	{
		PostResponse postDtos = this.postService.getAllPost(pageNumber,pageSize,sortBy);
		return new ResponseEntity<PostResponse>(postDtos,HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId)
	{
		PostDto postDto = this.postService.getOnePost(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId)
	{
		PostDto savedPostDto = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(savedPostDto,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId)
	{
		 this.postService.deletePost(postId);
		 return new ApiResponse("Post is deleted",true);
	}
	
	@GetMapping("/allTitle/{keyword}")
	public ResponseEntity<List<PostDto>> getAllTitle(@PathVariable String keyword)
	{
		List<PostDto> postDto = this.postService.serachByTitle(keyword);
		return new ResponseEntity<List<PostDto>>(postDto,HttpStatus.FOUND);
	}
	
	@PostMapping("/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage
	(@RequestParam("image") MultipartFile multiPartFile,
	@PathVariable Integer postId
	) throws IOException
	{
		Post post = new Post();
		PostDto onePost = this.postService.getOnePost(postId);
		String fileName = this.fileService.uplodaImage(path, multiPartFile);
		onePost.setImageName(fileName);
		PostDto updatePost = this.postService.updatePost(onePost, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/image/{imageName}",produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
	@PathVariable("imageName") String imageName,HttpServletResponse response) throws IOException
	{
		InputStream inputStream = this.fileService.getResource(path, imageName);
		response.setContentType(org.springframework.http.MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(inputStream, response.getOutputStream());
	}
	
}
