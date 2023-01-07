package com.yash.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yash.pms.dao.ProductDao;

public class App {

	public static void main(String[] args) {
		// System.out.println("Started");
		ApplicationContext app = new ClassPathXmlApplicationContext("com/yash/pms/config.xml");
		ProductDao productDao = app.getBean("productDao", ProductDao.class);
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Product pro = new Product();
		System.out.println("--------------------------WELCOME---------------------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean yes = true;
		while (yes) {
			System.out.println("PRESS 1:FOR INSERT");
			System.out.println("PRESS 2:TO DISPLAY");
			System.out.println("PRESS 3:TO UPDATE");
			System.out.println("PRESS 4:TO DELETE");
			System.out.println("PRESS 5:TO GET ONE PRODUCT");
			System.out.println("PRESS 6:TO EXIT");
			System.out.println("Enter The Number To Perform The Action");
			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:

					System.out.println("Enter The Product ID");
					int proId = sc.nextInt();
					System.out.println("Enter The Product Name ");
					String proName = sc1.next();
					System.out.println("Enter The Product Manfacturing Date");
					String proDate = sc1.next();
					System.out.println("Enter The Description Of The Product");
					String proDesc = sc2.next();
					System.out.println("Enter The Price Of Product");
					double proPrice = sc.nextDouble();
					Product pro1 = new Product();
					pro1.setProId(proId);
					pro1.setProName(proName);
					pro1.setProMfgDate(proDate);
					pro1.setProDescription(proDesc);
					pro1.setProPrice(proPrice);
					// Insert
					int result1 = productDao.insert(pro1);
					System.out.println("Number Of Action Perform " + result1);
					System.out.println("------------------------------------------");
					break;

				case 2:
					// get all product
					List<Product> product = productDao.getAllProduct();
					for (Product p : product) {
						System.out.println(p);
					}

					System.out.println("Here Is The List");
					System.out.println("");
					break;

				case 3:
					// update
					System.out.println("Enter The Product ID");
					int proId11 = sc.nextInt();
					System.out.println("Enter The Product Manfacturing Date");
					String proDate11 = sc1.next();
					System.out.println("Enter The Product Name ");
					System.out.println("");
					String proName11 = sc1.next();
					System.out.println("Enter The Description Of The Product");
					String proDesc11 = sc1.next();
					System.out.println("");
					System.out.println("Enter The Price Of Product");
					double proPrice11 = sc1.nextDouble();
					Product pro111 = new Product();
					pro111.setProMfgDate(proDate11);
					pro111.setProName(proName11);
					pro111.setProDescription(proDesc11);
					pro111.setProPrice(proPrice11);
					pro111.setProId(proId11);
					productDao.update(pro111);
					System.out.println("product updated successfully");
					System.out.println("");
					break;

				case 4:
					System.out.println("Enter The Product ID");
					int proId111 = sc.nextInt();
					int r1 = productDao.delete(proId111);
					System.out.println(r1);
					System.out.println("Product Deleted Successfully");
					System.out.println("");
					break;
				case 5:
					// Get One Product
					System.out.println("Enter The Product ID");
					int proId3 = sc.nextInt();
					Product pro2 = productDao.getOneProduct(proId3);
					System.out.println(pro2);
					System.out.println("Product Details :");
					System.out.println("");
					break;
				case 6:
					yes = false;
					break;
				}
			}

			catch (Exception e) {
				System.out.println("Invalid Input Please Enter Valid Input :");
				System.out.println(e.getStackTrace());
				System.out.println("");
			}
			System.out.println("Thanks For Visiting :");
			System.out.println("----------------------------------------------");
		}

	}
}

//System.out.println("Enter The Product ID");
//int proId = sc.nextInt();
//System.out.println("Enter The Product Name ");
//String proName = sc1.next();
//System.out.println("Enter The Product Manfacturing Date");
//String proDate = sc1.next();
//System.out.println("Enter The Description Of The Product");
//String proDesc = sc1.next();
//System.out.println("Enter The Price Of Product");
//String proPrice = sc1.next();
//Product pro = new Product();
//pro.setProId(proId);
//pro.setProName(proName);
//pro.setProMfgDate(proDate);
//pro.setProDescription(proDesc);
//pro.setProPrice(proPrice);
//Insert
//int result = productDao.insert(pro);
//System.out.println(result);
////update
//int result  = productDao.update(pro);
//System.out.println(result);
////Delete
//int r =	productDao.delete(proId);
//System.out.println(r);
//
////Get One Product
//Product pro = productDao.getOneProduct(proId);
//System.out.println(pro);

// JdbcTemplate template = app.getBean("jdbcTemplate",JdbcTemplate.class);
//    	String insert = "insert into product(proId,proName,proMfgDate,proDescription,proPrice) values (?,?,?,?,?)";
//    	int result = template.update(insert,proId,proName,proDate,proDesc,proPrice);
//    	System.out.println(result);