package com.databaseCon;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import com.databaseCon.Base;

public class Basedata implements Base{
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getCon() throws Exception {
		String url = "jdbc:mysql://localhost:3306/myapp";
		Connection con = (Connection) DriverManager.getConnection(url, "root", "1234");
		return con;
	}
	public void close(PreparedStatement ps,Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
		if (ps != null) {
			ps.close();
		}
	}
}
