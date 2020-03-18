package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;

import org.json.JSONException;
import org.json.JSONObject;

import com.databaseCon.Userinfo;
import com.databaseCon.Userinfodata;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
    @ResponseWrapper
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		StringBuffer sb =new StringBuffer(""); 
		
        String temp,userID=null,pass=null;  
       
        while((temp=br.readLine())!=null){  
            sb.append(temp);  
        }  
        //br.close();  
        System.out.println("sbtostring==========="+sb.toString());
        
        try {
			JSONObject jsonObject = new JSONObject(sb.toString());
			userID = jsonObject.getString("userid");
			pass = jsonObject.getString("password");
			 
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        Userinfo u=new Userinfo();
        Userinfodata ud=new Userinfodata();
        u.userID=userID;
        u.password=pass;
        try {
			Userinfo us = ud.findUser(u);
			if(us!=null)
			{
			  JSONObject jsonobject = new JSONObject();
			  jsonobject.put("userid", us.userID);
			  jsonobject.put("username", us.username);
			  jsonobject.put("userimg", us.userimg);
			  //System.out.println(jsonobject.getString("name"));
			  System.out.println(us);
				//Student student = new Student(name,pass);
		      out.print(jsonobject);
			//System.out.print(jsonobject);
			}
			else 
			{
				out.print("faile");
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
