package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.Product.Connection1;

public class K_Update_Price {
	public void updateprice() {
		H_admin_choice h_ad_choice=new H_admin_choice();
		Scanner sc=new Scanner(System.in);
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		System.out.println("Select ID of the Product of which Price you want to Update");
		int pro_ID=sc.nextInt();
		System.out.println("Set Price");
		int pro_price=sc.nextInt();
		try {
			PreparedStatement pd=c.prepareStatement("update product set price=? where id=?");
			pd.setInt(1,pro_price);
			pd.setInt(2,pro_ID);
			pd.executeUpdate();
					
		}
		catch(Exception e) {
			
		}System.out.println("Product Price Updated Successfully");
		System.out.println();
		h_ad_choice.getadminchoice();
	}
	}
	

