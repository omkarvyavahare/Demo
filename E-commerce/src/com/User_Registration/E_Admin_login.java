package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;

public class E_Admin_login {
	
	public void getadminlogin() {
		A_login_choice main_login=new A_login_choice();
		H_admin_choice h_ad_choice =new H_admin_choice();
		I_Dis_pro_list pro_list =new I_Dis_pro_list();
		
		Connection1 c1=new Connection1();
		Connection c=c1.conlogic();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Admin Email Id");
		String email=sc.next();
		System.out.println("Enter Admin Password");
		String pass=sc.next();
		int a=1;
		
		try {
			PreparedStatement pd=c.prepareStatement("Select * from admin");
			ResultSet rs=pd.executeQuery();
			while(rs.next()) {
				if(rs.getString(3).equals(email) && rs.getString(4).equals(pass)) {
					System.out.println("Admin Login Successfull..");
					System.out.println();
					a++;
					break;
				}
			}
			if(a==1) {
				System.out.println("Credentials Mismatch");
				System.out.println("Try login again");
				System.out.println();
				main_login.login();
				
			}
			if(a==2) {
				h_ad_choice.getadminchoice();
			}
		}
		catch(Exception e) {
			
		}
	}

}
