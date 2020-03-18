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

import com.databaseCon.AccessInfo;
import com.databaseCon.AccessInfoData;


@SuppressWarnings("serial")
public class getAccessInfo  extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");//重点
		PrintWriter out = response.getWriter();
		System.out.println("我走getAccessInfo");
		@SuppressWarnings("unused")
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		@SuppressWarnings("unused")
		StringBuffer sb =new StringBuffer(""); 
		
		AccessInfoData co=new AccessInfoData();
        try {
        	List<AccessInfo> cont= co.selecetAll();
			if(cont!=null)
			{
				JSONObject jsonobject = new JSONObject();
				
				   AccessInfo coo=cont.get(0);
					jsonobject.put("accessname", coo.accessname);
					jsonobject.put("accesstype", coo.accesstype);
					jsonobject.put("address", coo.address);
					//System.out.println(jsonobject.getString("\"accessname"+i+"\""));
				
				//jsonobject.put("num", cont.size());
				  //System.out.println(jsonobject.getString("\"accessname\""));
				  //System.out.println(cont.get(0));
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
