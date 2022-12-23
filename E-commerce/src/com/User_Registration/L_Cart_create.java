package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.Product.Connection1;

public class L_Cart_create {
	public void getcart(String email) {
		
		
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		//Scanner sc=new Scanner(System.in);
		
		//System.out.println("Enter Cart name");
		//String email=sc.next();
		
		
		
		try {
			PreparedStatement pd=c.prepareStatement("create table "+email+"(id int not null auto_increment,name varchar(255),price int,quantity int,status varchar(255),product_id int,primary key(id))");
			pd.execute();
			System.out.println("Your cart is created");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	  /*  public static void main(String args) {
		    L_Cart_create cart_c=new L_Cart_create();
		      cart_c.getcart();
	}*/
}
