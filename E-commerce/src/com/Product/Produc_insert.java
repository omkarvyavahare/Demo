package com.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Produc_insert {
	Connection1 c1=new Connection1();
	Connection c=c1.conlogic();
	
	public void Pre_state(String name,String discription,int price,int quantity) {
		try {
		PreparedStatement pd=c.prepareStatement("insert into product(name,discription,price,quantity)value(?,?,?,?)");
		pd.setString(1, name);
		pd.setString(2,discription);
		pd.setInt(3, price);
		pd.setInt(4, quantity);
		pd.executeUpdate();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

}
