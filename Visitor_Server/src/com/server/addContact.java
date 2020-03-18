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

import org.json.JSONException;
import org.json.JSONObject;

import com.databaseCon.Contact;
import com.databaseCon.ContactData;


@SuppressWarnings("serial")
public class addContact extends HttpServlet{
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		StringBuffer sb =new StringBuffer(""); 
		
        String temp;
        String userID=null,
             username=null,
             usercontimg=null,
             contacttel=null,
             state=null;
       
        while((temp=br.readLine())!=null){  
            sb.append(temp);  
        }  
        //br.close();  
        System.out.println("sbtostring==========="+sb.toString());
        
        try {
			JSONObject jsonObject = new JSONObject(sb.toString());
			userID = jsonObject.getString("userid");
			username = jsonObject.getString("username");
			state = jsonObject.getString("state");
			usercontimg=jsonObject.getString("usercontimg");
			contacttel=jsonObject.getString("contacttel");
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Contact c=new Contact();
        ContactData ud=new ContactData();
        c.userid=userID;
        c.name=username;
        c.accessState=state;
        c.img=usercontimg;
        c.tel=contacttel;
        try {
		    int  us = ud.insert(c);
			if(us!=0)
			{
				JSONObject jsonobject = new JSONObject();
				out.print(us);
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

}
