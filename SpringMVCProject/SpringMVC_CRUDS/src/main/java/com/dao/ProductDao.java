package com.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;

@Repository
public class ProductDao 
{
	
	@Autowired
	public HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product product) 
	{
		this.hibernateTemplate.saveOrUpdate(product);
	}

	//get all records
	public List<Product> getProducts()
	{
	 List<Product> products = this.hibernateTemplate.loadAll(Product.class);
	 return products;
	}
	
	//delete the single product
	@Transactional
	public void deleteProducts(int pid) 
	{
	   Product p=	this.hibernateTemplate.load(Product.class,pid);
	   this.hibernateTemplate.delete(p);
	}
	
	//get single product
	public Product getProduct(int pid) 
	{
		   return this.hibernateTemplate.get(Product.class,pid);
		   
	}
}
