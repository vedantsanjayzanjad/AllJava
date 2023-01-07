package com.yash.pms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.pms.Product;

public class RowMapperImpl implements RowMapper<Product>{

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product pro = new Product();
		pro.setProId(rs.getInt(1));
		pro.setProDescription(rs.getString(3));
		pro.setProMfgDate(rs.getString(4));
		pro.setProPrice(rs.getDouble(5));
		pro.setProName(rs.getString(2));
		return pro;
	}

}
