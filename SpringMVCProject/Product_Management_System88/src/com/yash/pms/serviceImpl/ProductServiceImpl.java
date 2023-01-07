package com.yash.pms.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.yash.pms.model.*;
import com.yash.pms.service.ProductService;

public class ProductServiceImpl implements ProductService {

	List<Product> c = new ArrayList<Product>();
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);

	@Override
	public void insertProduct() {

		System.out.println("**********WELCOME************");
		System.out.println("Insert the product id");
		int productId = sc.nextInt();

		System.out.println("Insert the product Name:");
		String productName = sc1.nextLine();

		System.out.println("Insert the product price:");
		int productPrice = sc.nextInt();

		System.out.println("Insert the product Quantity:");
		int productQuantity = sc.nextInt();

		c.add(new Product(productId, productName, productPrice, productQuantity));

	}

	@Override
	public void displayProduct() {
		// TODO Auto-generated method stub
		System.out.println("***********************");
		/*
		 * Iterator<Product> i = c.iterator(); while (i.hasNext()) { Product p =
		 * i.next(); System.out.println(p); }
		 */

		for (Product product : c) {
			System.out.println(product.toString());
		}

	}

	@Override
	public void searchProduct() {
		// TODO Auto-generated method stub
		boolean found = false;
		System.out.println("Enter the product Id:");
		int id = sc.nextInt();
		/*
		 * Iterator<Product> i = c.iterator(); while (i.hasNext()) { Product p =
		 * i.next(); if (p.getProductId() == id) { System.out.println(p); found = true;
		 * } }
		 */
		// c.stream().filter(id->p.getProductId()==id).forEach(System.out::println);
		// c.stream().map(Product::getProductId).filter(id->id==pid).collect(Collectors.toList());
		// c.stream().forEach(pp -> System.out.println("id" + pp.getProductId()==id));
		// List<Boolean> list = c.stream().map(p
		// ->p.getProductId()==id).collect(Collectors.toList());
		// list<Product> flist=c.stream().filter(p
		// ->p.getProductId()==id).collect(Collectors.toList());

		// c.stream().filter(p ->p.getProductId()==id ||p.getProductId()!=id
		// ).forEach(p->System.out.println(p.toString()))
		List<Product> li = c.stream().filter(p -> p.getProductId() == id).collect(Collectors.toList());
		if (!li.isEmpty()) {
			li.stream().forEach(p -> System.out.println(p.toString()));
		} else {
			System.out.println("Product not found");
		}
		/*
		 * e if(list.get(0)) { c.stream().forEach(prod->
		 * System.out.println(prod.toString())); }else{
		 * System.out.println("Product not found"); }
		 */

		System.out.println("*******************");

	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub
		System.out.println("please enter the product id for update");
		int id = sc.nextInt();
		System.out.println("insert the prodct name:");
		String productName = sc1.nextLine();

		System.out.println("insert the prodct price:");
		int productPrice = sc.nextInt();

		System.out.println("insert the prodct Quantity:");
		int productQunty = sc.nextInt();
		/*
		 * boolean found = false;
		 * System.out.println("please enter the product id for update"); int id =
		 * sc.nextInt(); ListIterator<Product> li = c.listIterator(); while
		 * (li.hasNext()) { Product p = li.next(); if (p.getProductId() == id) {
		 * System.out.println("insert the prodct name:"); String productName =
		 * sc1.nextLine();
		 * 
		 * System.out.println("insert the prodct price:"); int productPrice =
		 * sc.nextInt();
		 * 
		 * System.out.println("insert the prodct Quantity:"); int productQunty =
		 * sc.nextInt();
		 * 
		 * li.set(new Product(id, productName, productPrice, productQunty)); found =
		 * true;
		 */

		/*
		 * } }
		 * 
		 */

	List<Product> li	=c.stream().map(e -> {

			if (e.getProductId() == id) {e.setProductName(productName);e.setPrice(productPrice);e.setQuantity(productQunty);
			}

			return e;
		}).collect(Collectors.toList());

		if (li.isEmpty()) {
			System.out.println("Product not found");
		} else {
			System.out.println("Product is updated successfully");
		}

	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub

		System.out.println("Enter the product id ");
		int id = sc.nextInt();

		/*
		 * boolean found = false; System.out.println("Enter the product id "); int id =
		 * sc.nextInt(); Iterator<Product> i = c.iterator(); while (i.hasNext()) {
		 * Product p = i.next(); if (p.getProductId() == id) { i.remove(); found = true;
		 * } } if (!found) { System.out.println("Product not found"); } else {
		 * System.out.println("product is deleted successfully...!"); }
		 */
		List<Product> li = c.stream().filter(p -> p.getProductId() == id).collect(Collectors.toList());
		if (!li.isEmpty()) {
			c.remove(li.get(0));
			System.out.println("Product deleted Successfully");
		} else {
			System.out.println("Product not found");
		}

		System.out.println("******************************");

	}

}
