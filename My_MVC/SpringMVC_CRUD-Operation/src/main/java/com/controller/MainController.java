package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.ProductDao;
import com.model.Product;

@Controller
public class MainController {
	@Autowired
	private ProductDao productdao;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> products= productdao.getProducts();
		m.addAttribute("product",products);
		return "index";
	}
	
	//Show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model m) 
	{
		
		m.addAttribute("title","Add Product");
		return "add_product";
	}
	
	//handle add product form
	@RequestMapping(value="/handle-product",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) 
	{
		System.out.println(product);
		this.productdao.createProduct(product);
		RedirectView rv =new RedirectView();
		rv.setUrl(request.getContextPath() +"/");
		return rv;
	}
	
	//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct (@PathVariable("productId") int productId,HttpServletRequest request) 
	{
		this.productdao.deleteProducts(productId); 
		RedirectView rv =new RedirectView();
		rv.setUrl(request.getContextPath() +"/");
		return rv;
	}
	@RequestMapping("/update/{productId}")
	public String updateProduct (@PathVariable("productId") int productId,Model m) 
	{
	    Product product = this.productdao.getProduct(productId); 
		m.addAttribute("product",product);
		return "update_form";
	}
	
//for(String s : list)
//{
//	
//}
}
