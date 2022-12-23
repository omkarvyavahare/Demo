package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;

public class S_Add_toCart {
public void addtocart() {
	D_Sign_in d_signin =new D_Sign_in();
	O_User_Choice user_choice=new O_User_Choice();
	Connection1 c1=new Connection1();
	Connection c=c1.conlogic();
	String u_name=d_signin.name2;
	String p_name="";
	int p_price=0;
	int a=1;
	String status="Not Purchased";
	int product_quantity=0;
	
    Scanner sc=new Scanner(System.in);
    while(a==1) {
    System.out.println("Enter the id of the product which you want buy");
    int pro_id=sc.nextInt();
   
    try {
    PreparedStatement pd2=c.prepareStatement("select * from product where id=?");
    pd2.setInt(1, pro_id);
    ResultSet rs2=pd2.executeQuery();
    while(rs2.next()) {
    	product_quantity=rs2.getInt(5);
    }
    
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
   // System.out.println();
    //System.out.println("Stock available:- "+product_quantity);
    System.out.println();
    System.out.println("How much quantity do you want to buy");
    int pro_quan=sc.nextInt();
    if(product_quantity>=pro_quan) {
	try {
		PreparedStatement pd=c.prepareStatement("select * from product where id=?");
		pd.setInt(1, pro_id);
		ResultSet rs=pd.executeQuery();
		while(rs.next()) {
			p_name=rs.getString(2);
			p_price=rs.getInt(4);
			PreparedStatement pd1=c.prepareStatement("insert into "+u_name+"(name,price,quantity,status,product_id)value(?,?,?,?,?)");
			pd1.setString(1, p_name);
			pd1.setInt(2, p_price);
			pd1.setInt(3, pro_quan);
			pd1.setString(4, status);
			pd1.setInt(5, pro_id);
			pd1.executeUpdate();
			System.out.println("Product inserted to cart successfully...");
		}
		
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}

    }
    else {
    	System.out.println();
    	System.out.println("Product is out of Stock");
    	System.out.println("or You inserted more quantity than available in Stock");
    	
    }
    System.out.println();
	System.out.println("If u want to continue buying then Preess '1' or press any number ");
	a=sc.nextInt();
    }
    user_choice.getuserchoice();
    
}

}
