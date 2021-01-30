package com.khirod.kp;

import java.io.IOException
;
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

public class TestAServlet extends HttpServlet {
	
	private static final String EMPLOYEE_ENTRY="INSERT INTO EMPLOYEE3 VALUES(?,?,?,?,?,?,?)";
	
	public void doPost(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException {
		
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		
		String sname=req.getParameter("name");
		
		String sno=req.getParameter("num");
		
		int num=0;
		
		String sadd=req.getParameter("add");
		
		String location=req.getParameter("loc");
		
		String education=req.getParameter("edu");
		
		String gender=req.getParameter("gender");
		
		String status=req.getParameter("status");
		
		oracle.jdbc.driver.OracleDriver d=null;
		
		Connection con=null;
		
		PreparedStatement ps=null;
		
		int result =0;
		
		try {
			
			num=Integer.parseInt(sno);
			
			ServletConfig cg=getServletConfig();
			
			String driver=cg.getInitParameter("driverclass");
			
			String url=cg.getInitParameter("url");
			
			String user=cg.getInitParameter("user");
			
			String password=cg.getInitParameter("password");
			
			Class.forName(driver);
			
			con=DriverManager.getConnection(url,user,password);
			
			if(con!=null)
				ps=con.prepareStatement(EMPLOYEE_ENTRY);
			
			if(ps!=null) {
				ps.setString(1, sname);
				ps.setLong(2, num);
				ps.setString(3,sadd);
				ps.setString(4, location);
				ps.setString(5,education);
				ps.setString(6, gender);
				ps.setString(7, status);
			}
			
			if(ps!=null)
				result=ps.executeUpdate();
			
			if(result==1)
				pw.println("<h1 style='color:red;text-align:center'>Employee entry Added</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Employee entry not added</h1>");
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
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException{
	doPost(req,res);
}
}
