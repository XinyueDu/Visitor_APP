package com.databaseCon;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AccessInfoData extends Basedata implements AccessInfoBase {

	@Override
	public int insert(AccessInfo user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String accessname) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AccessInfo user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccessInfo> selecetAll() throws Exception {
		AccessInfo ac=null;
		List<AccessInfo> cont = new ArrayList<AccessInfo>();
		Connection con = null;
		PreparedStatement ps = null;
		
		int num=(int)(Math.random()*10);
		System.out.println(num);
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			//ps = (PreparedStatement) con.prepareStatement("select * from AccessInfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'");			
			String sql="select * from accessinfo where random='" + num + "'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ac=new AccessInfo();
				
				ac.setAccessname(rs.getString(1));
				ac.setAccesstype(rs.getString(2));
				ac.setAddress(rs.getString(3));
				cont.add(ac);
				
				System.out.println(rs.getString(2));
			}
			return cont ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(ps, con);
		}
		return cont;
	}

	

}
