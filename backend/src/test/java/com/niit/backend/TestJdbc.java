package com.niit.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
public static void main(String aa[]) throws SQLException {
	
	Connection con=DriverManager.getConnection("jdbc:h2:~/test","mithran","password");
	System.out.println(con);
	
}
}
