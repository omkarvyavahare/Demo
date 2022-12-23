/*package com.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.Product.Connection1;
import com.User_Registration.B_User_Registration;

public class Cart_create {
	
	public void getcart() {
		B_User_Registration u_regis=new B_User_Registration();
	
	Connection1 c1=new Connection1();
	Connection c=c1.conlogic();
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter your Email");
	String email=sc.next();
	
	try {
		PreparedStatement pd=c.prepareStatement("create table "+email+"(id int not null auto_increment,name varchar(255),price int,quantity int,primary key(id))");
		pd.execute();
		System.out.println("Your cart is created");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		Cart_create ct=new Cart_create();
		ct.getcart();
	}
}*/
