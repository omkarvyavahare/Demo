package com.User_Registration;

import java.sql.Connection;
import java.util.Scanner;

import com.Product.Connection1;

public class B_User_Registration {

	
	public  void new_user() {
		C_Pre_State_Usertable cu =new C_Pre_State_Usertable();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Username");
		String u_name=sc.next();
		System.out.println("Enter your Email");
		String u_email=sc.next();
		cu.pre_state_usertable(u_name,u_email);
		
		
		
	}

}
