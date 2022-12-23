package com.User_Registration;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;


public class C_Pre_State_Usertable {
	
	
	public void pre_state_usertable(String name,String u_email) {
		L_Cart_create cart_c=new L_Cart_create();
		A_login_choice lc=new A_login_choice();
		String pass2="";
		
		Scanner sc=new Scanner(System.in);
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		try {
		
		PreparedStatement pd=c.prepareStatement("select * from customer");
		ResultSet rs=pd.executeQuery();
		int no=1;
		while (rs.next()) {
			String useremail=rs.getString(3);
			String username=rs.getString(2);
			if(username.equals(name)) {
				System.out.println("User Already Exist");
				System.out.println();
				System.out.println("Go for sign in");
				System.out.println();
				lc.login();
				no++;
				break;
			}
			if(useremail.equals(u_email)) {
				System.out.println("User Already Exist");
				System.out.println();
				System.out.println("Go for sign in");
				System.out.println();
				lc.login();
				
				no++;
				break;
			}
		}
		int a=1;
		for(int i=0;i<3;i++) {
			
			if(no==1) {
				
				
			System.out.println("Enter your password");
			String pass1=sc.next();
			System.out.println("Confirm Your Password");
			String pass=sc.next();
			if(pass1.equals(pass)) {
				pass2=pass;
				
				System.out.println("Registerartion Successful..");
				PreparedStatement pd1 =c.prepareStatement("insert into customer(name,email,password)value(?,?,?)");
				pd1.setString(1, name);
				pd1.setString(2, u_email);
				pd1.setString(3, pass2);
				pd1.executeUpdate();
				System.out.println("Credentials Updated");
				System.out.println();
				cart_c.getcart(name);
				
				System.out.println("Now sign in");
				System.out.println();
				lc.login();
			    break;
				
			}
			else{
				System.out.println("Passord Mismatch");
				a++;
				}
			if(a>=4) {
				System.out.println();
				System.out.println("Try sign Up Again");
				lc.login();
				
			}
			}
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

}
