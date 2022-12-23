package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;

public class M_Remove_Customer {
	public void delete_cust() {
		H_admin_choice ad_choice=new H_admin_choice();
	Connection1 c1=new Connection1();
	Connection c=c1.conlogic();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the UserName which you want to delete");
	String username=sc.next();
	try {
		PreparedStatement pd=c.prepareStatement("delete from customer where name=?");
		PreparedStatement pd1=c.prepareStatement("drop table "+username);
		pd.setString(1,username);
		pd.execute();
		pd1.execute();
		System.out.println("User Deleted Successfully");
		
	}
	catch(Exception e) {
		System.out.println("Enter valid username or cheak username");
		//e.printStackTrace();
	}
	ad_choice.getadminchoice();
}
	
}