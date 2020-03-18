package com.databaseCon;

import java.util.ArrayList;
import java.util.List;
//import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



import com.databaseCon.UserinfoBase;
import com.databaseCon.Userinfo;

public class Userinfodata extends Basedata implements UserinfoBase {
	
	public int insert(Userinfo userinfo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.getCon();
			ps = (PreparedStatement) con.prepareStatement("insert into userinfo (userID,username,password,email,userimg) values(?,?,?,?,?)");
			ps.setString(1, userinfo.getUserID());
			ps.setString(2,userinfo.getUsername());
			ps.setString(3, userinfo.getPassword());
			ps.setString(4, userinfo.getEmail());
			ps.setString(5 , "¿É·Ã");
			ps.setString(6, "http://192.168.43.126:8080/VisitorApp/Image/c2.png");
			
			//ps.executeUpdate("insert into card (CardID,CardType,Passwords,State,Balance,OpenDate,CustomerID) values(12314124,'asdasd',?,?,?,?,?)");
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
	public int delete(int userid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Userinfo user) throws Exception {
		Userinfo us =null ;
		//Connection con = null;
//		Connection conn = ConnectionUtil.getConnection() ;
//		@SuppressWarnings("null")
//		Statement stmt = conn.createStatement() ;
//		String sql = "update userinfo set isState='"+user.state+"'where userID='"+user.userID+"'" ;
//		int rs = stmt.executeUpdate(sql) ;
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			String sql="update userinfo set isState='"+user.state+"'where userID='"+user.userID+"'" ;
			int rs = stmt.executeUpdate(sql);
			
			return rs ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(ps, con);
		}
		return 0;
	}

	@Override
	public List<Userinfo> selecetAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Userinfo> selectById(String userid) throws Exception {

		Userinfo us=null;
		List<Userinfo> cont = new ArrayList<Userinfo>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			String sql="select * from userinfo where userID='"+userid+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				us=new Userinfo();
				us.setUsername(rs.getString(2));
				us.setState(rs.getString(5));
				us.setUserimg(rs.getString(6));
				cont.add(us);
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
	
	
	
	public Userinfo findUser(Userinfo userinfo) throws Exception{
		Userinfo user = null;
		System.out.println("User ID"+userinfo.userID);
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			//ps = (PreparedStatement) con.prepareStatement("select * from userinfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'");			
			String sql="select * from userinfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				user = GetUserinfo(rs) ;
			}
			return user ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(ps, con);
		}
		return user;
	}
	
	public Userinfo GetUserinfo(ResultSet rs) throws Exception{
		Userinfo userinfo = new Userinfo();
		userinfo.userID=rs.getString(1);
		userinfo.username=rs.getString(2);
		userinfo.password=rs.getString(3);
		userinfo.userimg=rs.getString(6);
		return userinfo;
	}
	
}
