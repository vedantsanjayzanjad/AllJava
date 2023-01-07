package com.yash.pms.test;

import java.util.Scanner;

import com.yash.pms.model.*;
import com.yash.pms.service.*;
import com.yash.pms.serviceImpl.*;

public class Test {

	public static void main(String[] args) {

		ProductServiceImpl psi = new ProductServiceImpl();
		int userinput;

		Scanner sc = new Scanner(System.in);
		int exit = 0;
		while (exit == 0) {
			System.out.println("1.Insert");
			System.out.println("2.Display");
			System.out.println("3.Search");
			System.out.println("4.Update");
			System.out.println("5.Delete");
			System.out.println("6.Exit");
			System.out.println("Enter your choice");

			userinput = sc.nextInt();
			switch (userinput) {

			case 1:
				psi.insertProduct();
				break;

			case 2:
				psi.displayProduct();
				break;

			case 3:
				psi.searchProduct();
				break;

			case 4:
				psi.updateProduct();
				break;

			case 5:
				psi.deleteProduct();
				
				break;
			case 6:
				System.out.println("Exit");
				System.exit(0);
				break;
			default:
				System.out.println("Ivalid Choice");

			}

		}

	}

}
