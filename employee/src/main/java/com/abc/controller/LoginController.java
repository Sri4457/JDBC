package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.abc.dao.*;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DaoInterface dao=new DaoImple();
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
		String username=request.getParameter("fname").toLowerCase()+"_"+request.getParameter("lname");
		String password=request.getParameter("password");
		if(dao.checkLogin(username, password))
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Login Successfull');");
			   if(request.getParameter("role").equalsIgnoreCase("admin"))
				   out.print("location='Admin.html';");
			   else
			   {
				   RequestDispatcher rd = request.getRequestDispatcher("view_first_last");
				   rd.forward(request,response);
				   
			   }
			   out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Enter Details Correctly');");
			   out.println("location='login.html';");
			   out.println("</script>");
		}
	}

}
