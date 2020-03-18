package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;

import org.json.JSONException;
import org.json.JSONObject;

import com.databaseCon.Message;
import com.databaseCon.MessageData;



@SuppressWarnings("serial")
public class getMessage extends HttpServlet{
	@ResponseWrapper
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");//重点
		PrintWriter out = response.getWriter();
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		StringBuffer sb =new StringBuffer(""); 
		System.out.println("我是消息，我走这儿");
       String temp,userID=null;
        while((temp=br.readLine())!=null){  
          sb.append(temp);  
       }  
      //br.close();  
      System.out.println("sbtostring==========="+sb.toString());
      try {
			JSONObject jsonObject = new JSONObject(sb.toString());
			userID = jsonObject.getString("userid");
			 
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
		e1.printStackTrace();
	}
       
        Message m=new Message();
        MessageData me=new MessageData();
        m.userid=userID;
       
        try {
        	List<Message> mes= me.selectById(userID);
        	List<Message> mes2= me.selectById2(userID);
			if(mes!=null)
			{
				//JSONObject jsonobject = new JSONObject();接收的消息
				JSONObject jsonobject = new JSONObject();
				for(int i=0;i<mes.size();i++){
					Message ms=mes.get(i);
					
					jsonobject.put("\"name"+i+"\"", ms.contactname);
					jsonobject.put("\"time"+i+"\"", ms.time);
					jsonobject.put("\"reason"+i+"\"", ms.reason);
					jsonobject.put("\"state"+i+"\"", ms.state);
					jsonobject.put("\"image"+i+"\"", ms.contactimg);
					jsonobject.put("\"tel"+i+"\"", ms.tel);
					jsonobject.put("\"photo"+i+"\"", ms.photo);
					jsonobject.put("\"comments"+i+"\"", ms.comments);
					jsonobject.put("\"messageid"+i+"\"", ms.messageid);
					//System.out.println("\""+i+"\"");
					//System.out.println(jsonobject.getString("\"name"+i+"\""));
				}
				// 发送消息
				for(int i=mes.size();i<mes.size()+mes2.size();i++){
					Message ms2=mes2.get(i-mes.size());
					
					jsonobject.put("\"name"+i+"\"", ms2.username);
					jsonobject.put("\"time"+i+"\"", ms2.time);
					jsonobject.put("\"reason"+i+"\"", ms2.reason);
					jsonobject.put("\"state"+i+"\"", ms2.state);
					jsonobject.put("\"image"+i+"\"", ms2.userimg);
					jsonobject.put("\"tel"+i+"\"", ms2.tel);
					jsonobject.put("\"photo"+i+"\"", ms2.photo);
					jsonobject.put("\"comments"+i+"\"", ms2.comments);
					jsonobject.put("\"messageid"+i+"\"", ms2.messageid);
					//System.out.println("\""+i+"\"");
					//System.out.println(jsonobject.getString("\"name"+i+"\""));
				}
				
				jsonobject.put("num", mes.size()+mes2.size());
				  //System.out.println(jsonobject.getString("\"name"+1+"\""));
				  //System.out.println(mes.get(1));
				  //jsonobject.put("pass", "1234");
				  //jsonobject.put("name", "du");
				//jsonobject.put("key_success", "studentsuccess");
				//Student student = new Student(name,pass);
				out.print(jsonobject);
				//System.out.print(jsonobject);
			}
			else 
			{
				out.print("failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(request, response);
	}
}


