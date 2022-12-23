package com.User_Registration;

import java.util.Scanner;

import com.Product.Z_Inserting_product;

public class A_login_choice {
	public void login() {
		A_login_choice A_login_choice =new A_login_choice();
		H_admin_choice h_ad_choice = new H_admin_choice();
		G_Cheak_Quan c_quan=new G_Cheak_Quan();
		F_Dis_User_List user_list =new F_Dis_User_List();
		Z_Inserting_product add_pro =new Z_Inserting_product();
		E_Admin_login ad_login =new E_Admin_login();
		D_Sign_in sign_in =new D_Sign_in();
		B_User_Registration user_r =new B_User_Registration();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to E-commerce site");
		System.out.println("Give Your Choice");
		System.out.println("1:Sign Up ");
		System.out.println("2:Sign in");
		System.out.println("3:Admin Login");
		
		int login_choice=sc.nextInt();
		
		switch(login_choice)
		{
		case 1:user_r.new_user();
		       break;
			
		case 2: sign_in.getUser_login();
		       break;
		
		case 3:ad_login.getadminlogin();
		       break;
		      
		      
			
		default:System.out.println("invalid choice");
		System.out.println();
		A_login_choice.login();
		        
		break;
		}
		
	
	}

}
