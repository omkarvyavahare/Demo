package com.User_Registration;

import java.nio.channels.ReadPendingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;

public class T_User_History {
	public void getuserhistory() {
		H_admin_choice ad_choice =new H_admin_choice();
		
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username of customer of which history you want to get");
		String u_name=sc.next();
		try {
			System.out.println("Customer Puurches History is below");
			PreparedStatement pd=c.prepareStatement("select * from "+u_name);
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				System.out.print("ID of the Product "+rs.getInt(6)+"     ");
				System.out.print("Product name:- "+rs.getString(2)+"     ");
				System.out.print("Product price:- "+rs.getInt(3)+"     ");
				System.out.print("Product Quantity:-"+rs.getInt(4)+"     ");
				System.out.println("Status:-"+rs.getString(5));
				
			}
		}
		catch(Exception e) {
			System.out.println("Enter valid username or cheak username");
			//e.printStackTrace();
		}
		System.out.println();
		ad_choice.getadminchoice();
	}

}
