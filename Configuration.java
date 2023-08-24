package com.jsp.cofiguration;

import java.sql.Connection;
import java.sql.DriverManager;

public class Configuration {
	public static  Connection configure() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_dynamic", "root","1711");
		return conn;
		
	}
}
