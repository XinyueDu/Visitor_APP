package com.databaseCon;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class MessageData extends Basedata implements MessageBase{

	@Override
	public int insert(Message me) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.getCon();
			ps = (PreparedStatement) con.prepareStatement("insert into message(userid,contactname,reason,time,state,contactimage,tel,photo,comments,username,userimage) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, me.getUserid());
			ps.setString(2,me.getContactname());
			ps.setString(3, me.getReason());
			ps.setString(4, me.getTime());
			ps.setString(5, "未处理");
			ps.setString(6, me.getContactimg());
			ps.setString(7, me.getTel());
			ps.setString(8, me.getPhoto());
			ps.setString(9, me.getComments());
			ps.setString(10, me.getUsername());
			ps.setString(11, me.getUserimg());
			//ps.setString(8, me.getPhoto());
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
	public int delete(String name) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Message me) throws Exception {
		Message ms =null ;
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
			String sql="update message set state='"+me.state+"'where messageid='"+me.messageid+"'" ;
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
	public List<Message> selecetAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Message> selectById(String userid) throws Exception{
		Message mes=null;
		List<Message> mess = new ArrayList<Message>();
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			//ps = (PreparedStatement) con.prepareStatement("select * from userinfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'");			
			String sql="select * from message where userID='"+userid +"'";
			ResultSet rs = stmt.executeQuery(sql);


			while (rs.next()) {
				mes=new Message();
				mes.setContactname(rs.getString(2));
				mes.setReason(rs.getString(3));
				mes.setTime(rs.getString(5));
				mes.setState(rs.getString(6));
				mes.setContactimg(rs.getString(7));
				mes.setTel(rs.getString(8));
				mes.setPhoto(rs.getString(9));
				mes.setComments(rs.getString(10));
				mes.setMessageid(rs.getInt(13));
				mess.add(mes);
				System.out.println(rs.getString(2));
			}
			return mess ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(ps, con);
		}
		return mess;
	}
	
	public List<Message> selectById2(String userid) throws Exception{
		Message mes=null;
		List<Message> mess = new ArrayList<Message>();
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			//ps = (PreparedStatement) con.prepareStatement("select * from userinfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'");			
			
			String sqls="select * from message where tel='"+userid +"'";
			ResultSet rs2 = stmt.executeQuery(sqls);

			while (rs2.next()) {
				mes=new Message();
				mes.setUsername(rs2.getString(11));
				mes.setReason(rs2.getString(3));
				mes.setTime(rs2.getString(5));
				mes.setState(rs2.getString(6));
				mes.setUserimg(rs2.getString(12));
				mes.setTel(rs2.getString(1));
				mes.setPhoto(rs2.getString(9));
				mes.setComments(rs2.getString(10));
				mes.setMessageid(rs2.getInt(13));
				mess.add(mes);
				System.out.println(rs2.getString(2));
			}
			return mess ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(ps, con);
		}
		return mess;
	}
	
	public List<Message> findVisitorsRecord() throws Exception{
		Message mes=null;
		List<Message> mess = new ArrayList<Message>();
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = this.getCon();
			Statement stmt = con.createStatement() ;
			//ps = (PreparedStatement) con.prepareStatement("select * from userinfo where userID ='"+userinfo.userID +"' and password ='"+userinfo.password +"'");			
			String sql="select * from message where state='已处理'and userid='18729535144'";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				mes=new Message();
				mes.setContactname(rs.getString(2));
				//mes.setReason(rs.getString(2));
				mes.setData(rs.getString(4));
				mes.setTel(rs.getString(8));
				//mes.setImg(rs.getString(6));
				mess.add(mes);
				System.out.println(rs.getString(1));
			}
			return mess ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(ps, con);
		}
		return mess;
	}

}
