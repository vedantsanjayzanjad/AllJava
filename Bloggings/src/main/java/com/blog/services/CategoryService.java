package com.blog.services;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface CategoryService
{
	CategoryDto createCategory(CategoryDto catDto);
	
	List<CategoryDto> getAllCat();
	
	void deleteCatId(Integer catId);
	
	CategoryDto getOneCat(Integer catId);
	
	CategoryDto updatecat(CategoryDto catDto,Integer catId);
}
