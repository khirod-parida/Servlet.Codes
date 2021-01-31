package com.khirod.kp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShaddiServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException , IOException{
		
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		
		String sname=req.getParameter("name");
		
		String sage=req.getParameter("age");
		
		int age=Integer.parseInt(sage);
		
		String loc=req.getParameter("loc");
		
		String gender=req.getParameter("gender");
		
		String occupation =req.getParameter("ocp");
		
		pw.println("<body background='shaddi.jpg' style='background-repeat:no-repeat;background-size:100%'></body>");
		
		if(gender.equalsIgnoreCase("Male")) {
			
			if(age<18) {
				pw.println("<h1 style='color:red;text-align:center'>Age:"+" "+age+"</h1>");
				
				pw.println("<h1 style='color:red;text-align:center'>"+sname+" " +"your age is not fit for marriage"+"</h1>");
				}
			else
			{
				pw.println("<h1 style='color:red;text-align:center'>"+sname+"  "+"your age is fit for marriage "+"</h1>");
				
				pw.println("<h1 style='color:red;text-align:center'>"+"you are also having a good job as  "+occupation+"</h1>");
				
				pw.println("<h1 style='color:red;text-align:center'>"+"we will surely find a great match for u in "+loc+" "+"location"+"</h1>");
			}
		}
		else {

			if(age<18) {
				pw.println("<h1 style='color:red;text-align:center'>Age:"+" "+age+"</h1>");
				
				pw.println("<h1 style='color:red;text-align:center'>"+sname+" " +"your age is not fit for marriage"+"</h1>");
				}
			else
			{
				pw.println("<h1 style='color:red;text-align:center'>"+sname+"  "+"your age is fit for marriage "+"</h1>");
				
				pw.println("<h1 style='color:red;text-align:center'>"+"you are also having a good job as  "+occupation+"</h1>");
				
				pw.println("<h1 style='color:red;text-align:center'>"+"we will surely find a great match for u in "+loc+" "+"location"+"</h1>");
			}
			
		}
		pw.println("<br><b><a href='input.html'>Home</b></a>");
		
		pw.close();
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		doPost(req,res);
	}
}
