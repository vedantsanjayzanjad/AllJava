package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exceptions.ResourceNotFoundException;
import com.blog.model.Category;
import com.blog.model.User;
import com.blog.payloads.CategoryDto;
import com.blog.payloads.UserDto;
import com.blog.reposistories.CategoryDao;
import com.blog.services.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	private CategoryDao catDao;

	@Autowired
	private ModelMapper model;

	public Category dtoToCategory(CategoryDto catDto) {

		Category category = model.map(catDto, Category.class);
		return category;
	}

	public CategoryDto categoryToDto(Category cat) {

		CategoryDto categorydto = model.map(cat, CategoryDto.class);
		return categorydto;
	}

	@Override
	public CategoryDto createCategory(CategoryDto catDto) {

		Category dtoToCategory = this.dtoToCategory(catDto);
		Category save = this.catDao.save(dtoToCategory);
		return this.categoryToDto(save);
	}

	@Override
	public List<CategoryDto> getAllCat() {

		List<Category> categories = this.catDao.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map(e -> this.categoryToDto(e))
				.collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public void deleteCatId(Integer catId) {
		Category cat = this.catDao.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", catId));
		this.catDao.delete(cat);

	}

	@Override
	public CategoryDto getOneCat(Integer catId) {
		Category cat = this.catDao.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", catId));
		return this.categoryToDto(cat);
	}

	@Override
	public CategoryDto updatecat(CategoryDto catDto, Integer catId) {
		Category cat = this.catDao.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", catId));

		cat.setCategoryTitle(catDto.getCategoryTitle());
		cat.setCategoryDescription(catDto.getCategoryDescription());

		Category updatedCat = this.catDao.save(cat);
		CategoryDto updatedCatDto = this.categoryToDto(updatedCat);

		return updatedCatDto;
	}

}
