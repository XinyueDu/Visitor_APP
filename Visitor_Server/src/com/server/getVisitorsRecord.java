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

import org.json.JSONObject;

import com.databaseCon.Message;
import com.databaseCon.MessageData;

@SuppressWarnings("serial")
public class getVisitorsRecord extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");//÷ÿµ„
		PrintWriter out = response.getWriter();
		@SuppressWarnings("unused")
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		@SuppressWarnings("unused")
		StringBuffer sb =new StringBuffer(""); 
		
        MessageData me=new MessageData();
        try {
        	List<Message> mes= me.findVisitorsRecord();
			if(mes!=null)
			{
				JSONObject jsonobject = new JSONObject();
				for(int i=0;i<mes.size();i++){
					Message ms=mes.get(i);
					
					jsonobject.put("\"name"+i+"\"", ms.contactname);
					jsonobject.put("\"data"+i+"\"", ms.data);
					jsonobject.put("\"tel"+i+"\"", ms.tel);
					//jsonobject.put("\"state"+i+"\"", ms.state);
					//jsonobject.put("\"image"+i+"\"", ms.img);
					System.out.println("\""+i+"\"");
					System.out.println(jsonobject.getString("\"name"+i+"\""));
				}
				jsonobject.put("num", mes.size());
				  //System.out.println(jsonobject.getString("\"name"+1+"\""));
				  //System.out.println(mes.get(1));
				out.print(jsonobject);
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
