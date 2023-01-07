package com.yash.pms.dao;


import java.util.List;

import com.yash.pms.Product;

public interface ProductDao {

	public int insert(Product product);
	public int update(Product product);
	public int delete(int r);
	public Product getOneProduct(int proId);
	public List<Product> getAllProduct();
	
}
