package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;

public class F_Dis_User_List {
	
	public void getuserlist() {
		H_admin_choice h_ad_choice =new H_admin_choice();
		Scanner sc=new Scanner(System.in);
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		try {
		PreparedStatement pd = c.prepareStatement("select * from customer");
		ResultSet rs=pd.executeQuery();
		System.out.println("Registerd User List>>");
		while(rs.next()) {
			System.out.print("UserID:- "+rs.getInt(1)+"     ");
			System.out.print("Username:- "+rs.getString(2)+"     ");
			System.out.println("Email ID:- "+rs.getString(3));
		}
		
		}
		catch(Exception e) {
			
		}
		System.out.println();
		h_ad_choice.getadminchoice();
	}

}
