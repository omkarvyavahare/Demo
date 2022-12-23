package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;
import com.mysql.cj.protocol.Resultset;


public class D_Sign_in {
	
	static String name2;
	public void getUser_login() {
		D_Sign_in sign_in=new D_Sign_in();
		O_User_Choice user_choice=new O_User_Choice();
		A_login_choice lc=new A_login_choice();
		//R_Show_Cart_User show_cart =new R_Show_Cart_User();
		
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Email");
		String u_email=sc.next();
		System.out.println("Enter the Password");
		String u_pass=sc.next();
		String name="";
		int a=1;
		try {
			PreparedStatement pd=c.prepareStatement("select * from customer");
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				if(rs.getString(3).equals(u_email) && rs.getString(4).equals(u_pass)){
					System.out.println("Login Successfully");
					System.out.println();
					a++;
					break;
				}
				
			}
			if(a==1) {
				System.out.println("Email and Password Mismatch");
				System.out.println();
				System.out.println("Try sign in again");
				System.out.println();
				lc.login();
				
			}
			if(a==2) {
				try {
				PreparedStatement pd1=c.prepareStatement("select name from customer where email=?");
			    pd1.setString(1, u_email);
			    ResultSet rs1=pd1.executeQuery();
			    while(rs1.next()) {
			    	
			    	name=rs1.getString(1);
			    	
			    	sign_in.name2=rs1.getString(1);
			    }
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println();
				
				System.out.println("Welcome "+name+" !!!!!");
				user_choice.getuserchoice();
			}
			
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
/*public void getusercart() {
	
		
		System.out.println(name2+"Your cart is below:-");
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		try {
			PreparedStatement pd=c.prepareStatement("select * from "+name2);
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				System.out.print("ID:- "+rs.getInt(1)+"      ");
				System.out.print("Product name:- "+rs.getString(2)+"     ");
				System.out.print("Product price:- "+rs.getInt(3)+"     ");
				System.out.println("Product Quantity:- "+rs.getInt(4));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	

}
