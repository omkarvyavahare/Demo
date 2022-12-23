package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Product.Connection1;

public class P_Dis_pro_list_user {
	public void getprolist() {
		O_User_Choice user_choice=new O_User_Choice();
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		System.out.println();
		try {
			PreparedStatement pd=c.prepareStatement("select * from product");
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				
				System.out.print(rs.getInt(1)+"     ");
				System.out.print("Product name:-"+rs.getString(2)+"     ");
				System.out.print("Product Discription:-"+rs.getString(3)+"     ");
				System.out.print("Product Price:-"+rs.getInt(4)+"     ");
				System.out.println("Produt Quantity:-"+rs.getInt(5));
			}
			
		}
		catch(Exception e) {
			e.getMessage();
		}
		user_choice.getuserchoice();
		
	}

}
