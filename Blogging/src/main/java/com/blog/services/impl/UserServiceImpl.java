package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.model.User;
import com.blog.payloads.UserDto;
import com.blog.reposistories.UserDao;
import com.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User dtoToUser(UserDto userDto)
	{
		
		User user = modelMapper.map(userDto, User.class);
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}
	
	public UserDto userToDto(User user)
	{
		UserDto userDto = modelMapper.map(user, UserDto.class);
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userDao.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user","id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userDao.save(user);
		UserDto userDt = this.userToDto(updatedUser);
		return userDt;
	}

	@Override
	public UserDto getUserById(Integer userId) {
	
		User user = this.userDao.findById(userId).orElseThrow
				(() -> new ResourceNotFoundException("user","id", userId));
		 return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List <User> user = this.userDao.findAll();
		List<UserDto> userDto = user.stream().
				map(e -> this.userToDto(e)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		 
		User user = this.userDao.findById(userId).
				orElseThrow(() -> new ResourceNotFoundException("user","id", userId));
		this.userDao.delete(user);
	}

}
