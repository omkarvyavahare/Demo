package com.Product;

import java.util.Scanner;

import com.User_Registration.H_admin_choice;

public class Z_Inserting_product {

	public void pro_insert() {
		H_admin_choice h_ad_choice = new H_admin_choice();
		
		Produc_insert pi=new Produc_insert();
		Scanner sc=new Scanner(System.in);
		System.out.println("How many products do you want add");
		int a=sc.nextInt();
		for(int i=0;i<a;i++) {
			System.out.println("Enter the Product name");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Enter the Disctription");
			String discription=sc.nextLine();
			System.out.println("Enter the price");
			int price=sc.nextInt();
			System.out.println("Enter the quantity");
			int quantity=sc.nextInt();
			
			pi.Pre_state(name, discription, price, quantity);
		}
		System.out.println("Product inserted Successfully");
		System.out.println();
		h_ad_choice.getadminchoice();
		}
}
