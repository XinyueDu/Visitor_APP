package com.databaseCon;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public interface Base {
	public Connection getCon() throws Exception;

	public void close(PreparedStatement ps, Connection con) throws Exception;


}
