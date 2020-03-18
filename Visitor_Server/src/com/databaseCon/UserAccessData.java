package com.databaseCon;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserAccessData extends Basedata implements UserAccessBase{

	@Override
	public int insert(UserAccess user) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.getCon();
			ps = (PreparedStatement) con.prepareStatement("insert into useraccess (userID,accessname,address) values(?,?,?) ");
			ps.setString(1,user.getUserID());
			ps.setString(2,user.getAccessname());
			ps.setString(3, user.getAddress());
			int num = ps.executeUpdate();
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(ps, con);
		}
		return 0;
	}

	@SuppressWarnings("null")
	public int delete(String accessname) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from useraccess where accessname=?";
		ps = (PreparedStatement) con.prepareStatement(sql);
		// 6.给sql语句赋值
		//ps.setInt(1, user.getUserid());
		// 增删改都采用此方法
		// 7.执行sql语句
		int num = ps.executeUpdate();
		return num;
		
		
	}

	@Override
	public int update(UserAccess user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserAccess> selecetAll() throws Exception {
		
		UserAccess ua=null;
		List<UserAccess> cont = new ArrayList<UserAccess>();
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			//ps = (PreparedStatement) con.prepareStatement("select * from userinfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'");			
			String sql="select * from useraccess";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ua=new UserAccess();
				ua.setUserID(rs.getString(1));
				ua.setAccessname(rs.getString(2));
				ua.setAddress(rs.getString(3));
				
				cont.add(ua);
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
public List<UserAccess> selecetByID(String userid) throws Exception {
		
		UserAccess ua=null;
		List<UserAccess> cont = new ArrayList<UserAccess>();
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			//ps = (PreparedStatement) con.prepareStatement("select * from userinfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'");			
			String sql="select * from useraccess where userID='"+userid+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ua=new UserAccess();
				ua.setUserID(rs.getString(1));
				ua.setAccessname(rs.getString(2));
				ua.setAddress(rs.getString(3));
				
				cont.add(ua);
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


