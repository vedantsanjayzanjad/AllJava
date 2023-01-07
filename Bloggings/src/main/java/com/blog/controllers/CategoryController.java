package com.blog.controllers;

import java.util.List;
//import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;

//import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController
{
	@Autowired
	private CategoryService catService;
	
	@PostMapping("/addCat")
	public ResponseEntity<CategoryDto> saveCat(@RequestBody CategoryDto catDto)
	{
		 CategoryDto createCategory = this.catService.createCategory(catDto);
		 return new ResponseEntity<>(createCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateUser(@javax.validation.Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId)
	{
		CategoryDto updatecat = this.catService.updatecat(categoryDto, catId);
		return new ResponseEntity<>(updatecat,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId)
	{
		this.catService.deleteCatId(catId);
		return new ResponseEntity<ApiResponse>
		(new ApiResponse("Category Found !!!",true),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoryDto>> getAllCat()
	{
		return ResponseEntity.ok(this.catService.getAllCat());
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCat(@PathVariable Integer catId)
	{
		return ResponseEntity.ok(this.catService.getOneCat(catId));
	}
}
