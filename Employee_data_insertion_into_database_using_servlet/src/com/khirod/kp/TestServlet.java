package com.khirod.kp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	private static final String EMPLOYEE_INSERTION="INSERT INTO EMPLOYEE1 VALUES(?,?,?,?,?)";
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	
	res.setContentType("text/html");
	
	PrintWriter pw=res.getWriter();
	
	String sname=req.getParameter("name");
	
	String snum=req.getParameter("num");
	
	String sadd=req.getParameter("add");
	
	String sjob=req.getParameter("job");
	
	String ssal=req.getParameter("sal");
	
	int num=0;
	
	int sal=0;
	
	int count=0;
	
	oracle.jdbc.driver.OracleDriver d=null;
	
	Connection con=null;
	
	PreparedStatement ps=null;
	
	try {
		
		num=Integer.parseInt(snum);
		sal=Integer.parseInt(ssal);
		
		ServletConfig cg=getServletConfig();
		
		String driver=cg.getInitParameter("driverclass");
		
		String url=cg.getInitParameter("url");
		
		String user=cg.getInitParameter("user");
		
		String password=cg.getInitParameter("password");
		
		
		Class.forName(driver);
		
	
		con=DriverManager.getConnection(url,user,password);
		
		if(con!=null)
			ps=con.prepareStatement(EMPLOYEE_INSERTION);
		
		if(ps!=null) {
			ps.setInt(1,num );
			
			ps.setString(2, sname);
			
			ps.setString(3, sadd);
			
			ps.setString(4, sjob);
			
			ps.setInt(5, sal);
		}
			
		
		if(ps!=null)
			count=ps.executeUpdate();
		
		if(count==1)
			pw.println("<h1 style='color:red;text-align:center'>Employee updated</h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'>Employee not updated</h1>");
		
		
		
	}
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	pw.println("<br><a href='input.html'>home</a>");
	pw.close();
	
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException {
		doPost(req,res);
	}
	
	
	

}
