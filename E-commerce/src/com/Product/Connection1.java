package com.Product;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection1 {
	Connection con=null;
	
	public Connection conlogic() {
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","root");
			
		}
		catch(Exception e) {
			e.getMessage();
		}
		System.out.println("Connection Successful...");
		return con;
		
	}
	
}
