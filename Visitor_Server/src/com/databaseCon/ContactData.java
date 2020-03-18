package com.databaseCon;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ContactData extends Basedata implements ContactBase{

	@Override
	public int insert(Contact co) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.getCon();
			ps = (PreparedStatement) con.prepareStatement("insert into contact(userID,name,accessState,signs,image,tel) values(?,?,?,?,?,?) ");
			ps.setString(1,co.getUserid());
			ps.setString(2,co.getName());
			ps.setString(3, co.getAccessState());
			ps.setString(4, "面朝大海，春暖花开");
			ps.setString(5, co.getImg());
			ps.setString(6, co.getTel());
			int num = ps.executeUpdate();
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(ps, con);
		}
		return 0;
	}

	@Override
	public int delete(String name) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Contact co) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> selectById(String userid) throws Exception {
		Contact co=null;
		List<Contact> cont = new ArrayList<Contact>();
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			//ps = (PreparedStatement) con.prepareStatement("select * from userinfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'");			
			String sql="select * from contact where userID='"+userid +"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				co=new Contact();
				co.setName(rs.getString(2));
				co.setAccessState(rs.getString(3));
				co.setSigns(rs.getString(4));
				co.setImg(rs.getString(5));
				co.setTel(rs.getString(6));
				
				cont.add(co);
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
