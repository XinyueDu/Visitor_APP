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

import com.databaseCon.Message;
import com.databaseCon.MessageData;
import com.server.SavePic;

@SuppressWarnings("serial")
public class SendVisitorReq extends HttpServlet {
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
        String userID=null, contactname=null, username=null, reason=null,
              tel=null,    time=null,contactimg=null,userimg=null, comments=null;
       
        while((temp=br.readLine())!=null){  
            sb.append(temp);  
        }  
        //br.close();  
        System.out.println("sbtostring==========="+sb.toString());
        
        try {
			JSONObject jsonObject = new JSONObject(sb.toString());
			userID = jsonObject.getString("userid");
			contactname = jsonObject.getString("contactname");
			username=jsonObject.getString("username");
			reason = jsonObject.getString("reason");
			tel = jsonObject.getString("tel");
			time = jsonObject.getString("time");
			contactimg= jsonObject.getString("contactimg");
			userimg=jsonObject.getString("userimg");
			comments = jsonObject.getString("comment");
			 
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        SavePic sp=new SavePic();
        
        Message ms=new Message();
        MessageData md=new MessageData();
        ms.userid=userID;
        ms.contactname=contactname;
        ms.username=username;
        ms.reason=reason;
        ms.tel=tel;
        ms.time=time;
        ms.contactimg=contactimg;
        ms.userimg=userimg;
        ms.comments=comments;
        ms.photo=sp.getPhotoPath();
        try {
		    int  mes = md.insert(ms);
			if(mes!=0)
			{
				JSONObject jsonobject = new JSONObject();
				//jsonobject.put("key_success", "studentsuccess");
				
				//Student student = new Student(name,pass);
				//out.print("success");
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
}