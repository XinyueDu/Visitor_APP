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

import com.databaseCon.UserAccess;
import com.databaseCon.UserAccessData;


@SuppressWarnings("serial")
public class blindAccess extends HttpServlet{
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
             accessname=null,
             address=null;
       
        while((temp=br.readLine())!=null){  
            sb.append(temp);  
        }  
        //br.close();  
        System.out.println("sbtostring==========="+sb.toString());
        
        try {
			JSONObject jsonObject = new JSONObject(sb.toString());
			userID = jsonObject.getString("userid");
			accessname = jsonObject.getString("accessname");
			address = jsonObject.getString("address");
			//emil = jsonObject.getString("emil");
			 
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        UserAccess u=new UserAccess();
        UserAccessData ud=new UserAccessData();
        u.userID=userID;
        u.accessname=accessname;
        u.address=address;
       // u.email=emil;
        try {
		    int  us = ud.insert(u);
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
