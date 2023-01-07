package com.yash.pms.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.yash.pms.Product;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Product product) {

		String insert = "insert into product(proId,proName,proMfgDate,proDescription,proPrice) values (?,?,?,?,?)";
		int r = this.jdbcTemplate.update(insert,product.getProId(),product.getProName(),product.getProMfgDate(),product.getProDescription(),product.getProPrice());
		return r;
	}

	public int update(Product product) {
		String update = "update product set proMfgDate = ?,proName = ?,proDescription = ?,proPrice = ? where proId = ?";
		int r = this.jdbcTemplate.update(update,product.getProMfgDate(),product.getProName(),product.getProDescription(),product.getProPrice(),product.getProId());
		return r;
	}

	public int delete(int proId)
	{
		String delete = "delete from product where proId = ?";
		this.jdbcTemplate.update(delete,proId);
		return 0;
		}

	public Product getOneProduct(int proId) {
		String delete = "select * from product where proId = ?";
		RowMapper<Product> rowMapper = new RowMapperImpl();
		Product pro = this.jdbcTemplate.queryForObject(delete, rowMapper,proId);
		return pro;
		
	}
	
	public List<Product> getAllProduct()
	{
		String query = "select * from product";
		List <Product> product = this.jdbcTemplate.query(query, new RowMapperImpl());
		return product;
	}
}
