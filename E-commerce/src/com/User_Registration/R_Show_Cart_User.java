package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Product.Connection1;

public class R_Show_Cart_User {
	
	
	
	public void getusercart() {
		O_User_Choice user_choice=new O_User_Choice();
		D_Sign_in sign_in=new D_Sign_in();
		String name=sign_in.name2;
		System.out.println(name+" Your cart is below:-");
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		try {
			PreparedStatement pd=c.prepareStatement("select * from "+name);
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				System.out.print("Product ID:- "+rs.getInt(1)+"      ");
				System.out.print("Product name:- "+rs.getString(2)+"     ");
				System.out.print("Product price:- "+rs.getInt(3)+"     ");
				System.out.print("Product Quantity:- "+rs.getInt(4)+"     ");
				System.out.println("Status:-"+rs.getString(5));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		user_choice.getuserchoice();
		
	}
	}


