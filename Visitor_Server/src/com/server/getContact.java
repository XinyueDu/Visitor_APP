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

import com.databaseCon.Contact;
import com.databaseCon.ContactData;

@SuppressWarnings("serial")
public class getContact extends  HttpServlet{
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
			System.out.println("我是联系人，我走这儿");
	         ContactData co=new ContactData();
	        String temp, userID=null;
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
	        try {
	        	List<Contact> cont= co.selectById(userID);
				if(cont!=null)
				{
					JSONObject jsonobject = new JSONObject();
					for(int i=0;i<cont.size();i++){
						Contact coo=cont.get(i);
						
						jsonobject.put("\"name"+i+"\"", coo.name);
						jsonobject.put("\"accessState"+i+"\"", coo.accessState);
						//jsonobject.put("\"reason"+i+"\"", .reason);
						jsonobject.put("\"signs"+i+"\"", coo.signs);
						jsonobject.put("\"image"+i+"\"", coo.img);
						jsonobject.put("\"tel"+i+"\"", coo.tel);
						System.out.println("\""+i+"\"");
						System.out.println(jsonobject.getString("\"name"+i+"\""));
					}
					jsonobject.put("num", cont.size());
					  //System.out.println(jsonobject.getString("\"name"+1+"\""));
					  //System.out.println(cont.get(1));
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
