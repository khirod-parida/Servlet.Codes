package com.khirod.kp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
		
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		
		String sname=req.getParameter("name");
		
		Date date=new Date();
		
		int time=date.getHours();
	
		if(time<12)
			pw.println("<h1 style='color:red;text-align:center'>Good Morning"+" "+sname+" "+"</h1>");
		else if(time<17)
			pw.println("<h1 style='color:red;text-align:center'>Good Afternoon"+" "+sname+" "+"</h1>");
		else if(time<23)
			pw.println("<h1 style='color:red;text-align:center'>Good Evenging"+" "+sname+" "+"</h1>");
		
		else
			pw.println("<h1 style='color:red;text-align:center'>Good Night"+" "+sname+" "+"</h1>");
		
	
		
		pw.println("<br><a href='input.html'>home</a>");
		
		pw.close();
	
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}
}

