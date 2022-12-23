package com.User_Registration;

import java.util.Scanner;

import com.Product.Z_Inserting_product;

public class H_admin_choice {
	public void getadminchoice() {
		H_admin_choice H_ad_choice =new H_admin_choice();
		T_User_History user_history =new T_User_History();
		M_Remove_Customer Rev_cust =new M_Remove_Customer();
		K_Update_Price update_price=new K_Update_Price();
		J_Update_Quantity update_qun=new J_Update_Quantity();
		I_Dis_pro_list pro_list =new I_Dis_pro_list();
		A_login_choice main_login=new A_login_choice();
		Scanner sc=new Scanner(System.in);
		Z_Inserting_product add_pro =new Z_Inserting_product();
		G_Cheak_Quan c_quan=new G_Cheak_Quan();
		F_Dis_User_List user_list =new F_Dis_User_List();
		
		 System.out.println("Welcome Admin!!!! Your Choices are");
		   System.out.println("1:Show Product Info");
	       System.out.println("2:Insert Products");
	       System.out.println("3:Update Quantity");
	       System.out.println("4:Update Price");
	       System.out.println("5:Get Product Quntity");
	       System.out.println("6:Display User List");
	       System.out.println("7:Show user History");
	       System.out.println("8:Delete User");
	       System.out.println("9:Sign out");
	       int ad_choice=sc.nextInt();
	       switch(ad_choice)
	       {
	       case 1:pro_list.getprolist();
	       break;
	       case 2:add_pro.pro_insert();
	       break;
	       
	       case 3:update_qun.updatequantity();
	       break;
	       
	       case 4:update_price.updateprice();
	       break;
	    	   
	       case 5:c_quan.getproductQuantity();
	       break;
	       
	       case 6:user_list.getuserlist();
	       break;
	       
	       case 7:user_history.getuserhistory();
	       break;
	       
	       case 8:Rev_cust.delete_cust();
	       break;
	       
	       case 9:main_login.login();
	       break;
	    	   
	       default:System.out.println("invalid choice");
	       System.out.println();
	       H_ad_choice.getadminchoice();
	       break;   
	       }
	       
	}

}
