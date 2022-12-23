package com.User_Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Product.Connection1;

public class U_Update_Status {
	
	public void getstatus() {
		O_User_Choice user_choice =new O_User_Choice();
	D_Sign_in signin=new D_Sign_in();
	R_Show_Cart_User show_cart=new R_Show_Cart_User();
		String u_name=signin.name2;
		
	Connection1 c1=new Connection1();
	Connection c=c1.conlogic();
	
	
	
	
	try {
		System.out.println(u_name+" Your Cart Status is Below:-");
		System.out.println();
		PreparedStatement pd4=c.prepareStatement("select * from "+u_name);
		ResultSet rs=pd4.executeQuery();
		while(rs.next()) {
			System.out.print("Product ID:- "+rs.getInt(1)+"      ");
			System.out.print("Product name:- "+rs.getString(2)+"     ");
			System.out.print("Product price:- "+rs.getInt(3)+"     ");
			System.out.print("Product Quantity:- "+rs.getInt(4)+"     ");
			System.out.println("Status:-"+rs.getString(5));
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	int a=1;
	int cart_quantity=0;
	int product_id=0;
	int product_quantity=0;
	int new_quantity=0;
	int pro_price=0;
	int b=0;
	String pro_name="";
	int total_amount=0;
	
	int product_quantity2=0;
	
	
	System.out.println();
	while(a==1) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Product ID of Cart");
	System.out.println("After Entering Product ID of cart it will Confirm order");
	int pro_id=sc.nextInt();
	String status="Purchased";
	String status2="Not Purchased";
	
	try {
		PreparedStatement pd5=c.prepareStatement("select * from "+u_name+" where id=?");
		pd5.setInt(1,pro_id);
		ResultSet rs5=pd5.executeQuery();
		while(rs5.next()) {
			int cart_quantity2=rs5.getInt(4);
			int product_id2=rs5.getInt(6);
			//System.out.println("Cart Quantity>> "+cart_quantity2);
			//System.out.println("pro id>> "+product_id2);
			String status1=rs5.getString(5);
			PreparedStatement pd6=c.prepareStatement("select * from product where id=?");
			pd6.setInt(1, product_id2);
			ResultSet rs6=pd6.executeQuery();
			while(rs6.next()) {
				product_quantity2=rs6.getInt(5);
				//System.out.println("Quantity is>>"+product_quantity2);
			}
			if(status2.equals(status1)){
				if(product_quantity2>cart_quantity2) {
				
				try {
					PreparedStatement pd=c.prepareStatement("update "+u_name+" set status=? where id=?");
					pd.setString(1, status);
					pd.setInt(2, pro_id);
					pd.executeUpdate();
					PreparedStatement pd1=c.prepareStatement("select * from "+u_name+" where id=?");//fetching cart_quantity and product_id 
					pd1.setInt(1, pro_id);
					ResultSet rs=pd1.executeQuery();
					while(rs.next()) {
						pro_name=rs.getString(2);
					    pro_price=rs.getInt(3);
						cart_quantity=rs.getInt(4);
						product_id=rs.getInt(6);
					}
					PreparedStatement pd2=c.prepareStatement("select * from product where id=?");//fetching product quantity
					pd2.setInt(1, product_id);
					ResultSet rs1=pd2.executeQuery();
					while(rs1.next()) {
						product_quantity=rs1.getInt(5);
					}
					new_quantity=product_quantity-cart_quantity;//Updating Product table quantity
					PreparedStatement pd3 =c.prepareStatement("update product set quantity=? where id=?");
					pd3.setInt(1,new_quantity );
					pd3.setInt(2,product_id);
					pd3.executeUpdate();
					
					//System.out.println(cart_quantity+" "+product_id+" "+product_quantity);
					
					System.out.println(pro_name+" Orderd Successfully...");
					
					System.out.println();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
				else {
					System.out.println("This Amount of Quantity is Not available in Stock");
				}
			}
			else {
				System.out.println("Product brought Already");
			}
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	System.out.println("For Continue Purchasing press '1' if not press any number");
	a=sc.nextInt();
	b++;
	total_amount=total_amount+(pro_price*cart_quantity);
	}
	System.out.println(" Order Placed Successfully....");
	System.out.println();
	System.out.println("Total amount of this Purchase is Rs "+total_amount+"/-");
	System.out.println();
	user_choice.getuserchoice();
	}
}
