package com.User_Registration;

import java.util.Scanner;

public class O_User_Choice {
	
public void getuserchoice() {
	O_User_Choice O_U_C =new O_User_Choice();
	U_Update_Status update_status=new U_Update_Status();
	S_Add_toCart add_cart =new S_Add_toCart();
	D_Sign_in sign_in=new D_Sign_in();
	P_Dis_pro_list_user dis_pro =new P_Dis_pro_list_user();
	A_login_choice login=new A_login_choice();
	R_Show_Cart_User user_cart=new R_Show_Cart_User();
	String name1=sign_in.name2;
	
	Scanner sc=new Scanner(System.in);
	System.out.println();
	System.out.println("Customer Choices are");
	System.out.println("Enter your choice");
	System.out.println("1: Show Products");
	System.out.println("2: Buy Products");
	System.out.println("3: Show your Cart");
	System.out.println("4: Confirm Purchase");
	System.out.println("5: Sign out");
	
	int user_choice=sc.nextInt();
	switch(user_choice) {
	 
	case 1:dis_pro.getprolist();
		break;
		
	case 2:add_cart.addtocart();
		
	       
		 break;
		
	case 3:user_cart.getusercart();
	       //sign_in.getusercart();
	
		 break;
		 
	case 4:update_status.getstatus();
	break;
		
	case 5:login.login();
		break;
		
		default: System.out.println("Invalid Choice");
		System.out.println();
		O_U_C.getuserchoice();
		break;
	}
	
}
}
