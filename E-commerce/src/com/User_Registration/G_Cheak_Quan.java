package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;

public class G_Cheak_Quan {
	public void getproductQuantity() {
		H_admin_choice h_ad_choice =new H_admin_choice();
		Scanner sc=new Scanner(System.in);
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		
		System.out.println("Enter the Product name Which quantity you want");
		String name=sc.nextLine();
		try {
			PreparedStatement pd=c.prepareStatement("select quantity from product where name=? ");
			pd.setString(1,name);
			
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				System.out.println("Product Quantity is "+rs.getString(1));
			}
			
		}
		catch(Exception e){
			
		}
		System.out.println();
		h_ad_choice.getadminchoice();
	}
	

}
