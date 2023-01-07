package com.blog.services.impl;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.model.Category;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.reposistories.CategoryDao;
import com.blog.reposistories.PostDao;
import com.blog.reposistories.UserDao;
import com.blog.services.PostService;
//import jakarta.persistence.PostRemove;
import javax.persistence.*;

@Service
public class PostImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CategoryDao catDao;

	@Override
	public PostDto creatpost(PostDto postDto, Integer categoryId, Integer userId) {

		User user = this.userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		Category cat = this.catDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImage("default.png");
		post.setAddedDate(new Date());
		post.setCategory(cat);
		post.setUser(user);
		Post newPost = this.postDao.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postDao.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImage(postDto.getImageName());

		this.postDao.save(post);
		return this.modelMapper.map(post, PostDto.class);

	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postDao.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
		this.postDao.delete(post);
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy) {

		org.springframework.data.domain.Pageable p = PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));
		Page<Post> pagePost = this.postDao.findAll(p);
		List<Post> post = pagePost.getContent();
		// List<Post> post = this.postDao.findAll();
		List<PostDto> collect = post.stream().map((posts) -> this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());

		PostResponse postResponse = new PostResponse();
		postResponse.setContent(collect);
		postResponse.setPageNumber(pageNumber);
		postResponse.setPageSize(pageSize);
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		return postResponse;
	}

	@Override
	public PostDto getOnePost(Integer postId) {

		Post post = this.postDao.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
		PostDto map = this.modelMapper.map(post, PostDto.class);
		return map;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat = this.catDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
		List<Post> post = this.postDao.findByCategory(cat);
		List<PostDto> postDto = post.stream().map((posts) -> this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		List<Post> post = this.postDao.findByUser(user);
		List<PostDto> postDto = post.stream().map((posts) -> this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> serachByTitle(String keyword) {
		List<Post> allTitle = this.postDao.serachByTitle("%"+keyword+"%");
		List<PostDto> collect = allTitle.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

}
