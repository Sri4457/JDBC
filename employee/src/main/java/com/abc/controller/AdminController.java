package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.DaoImple;
import com.abc.dao.DaoInterface;
import com.abc.model.Employee;

@WebServlet(urlPatterns= {"/registration","/update","/delete","/view_all"})
public class AdminController extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		String path=request.getServletPath();
		DaoInterface dao=new DaoImple();
		PrintWriter out=response.getWriter();
		Employee e=new Employee();
		
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		switch(path)
		{
		case "/registration":
			
			e.setAddress(request.getParameter("address"));
			e.setDate(Date.valueOf(request.getParameter("dob")));
			e.setFirst_name(request.getParameter("fname"));
			e.setLast_name(request.getParameter("lname"));
			e.setGender(request.getParameter("gender"));
			e.setMobile(Long.parseLong(request.getParameter("mobile")));
			e.setPassword(request.getParameter("password"));
			e.setSal(Double.parseDouble(request.getParameter("salary")));
			e.setEmail(request.getParameter("email"));	
			e.setAge(Date.valueOf(request.getParameter("dob")));
			e.setUsername(request.getParameter("fname").toLowerCase()+"_"+request.getParameter("lname").toLowerCase());
			if(dao.addEmployee(e))
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("confirm(\"Successfully added employee and the username is firstname_lastname\");");
				   out.println("location='Admin.html';");
				   out.println("</script>");
				
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Something Went Wrong');");
				   out.println("location='Admin.html';");
				   out.println("</script>");
			}
			break;
		case "/update":
			e.setAddress(request.getParameter("address"));
			e.setAge(Date.valueOf(request.getParameter("age")));
			e.setFirst_name(request.getParameter("fname"));
			e.setLast_name(request.getParameter("lname"));
			e.setMobile(Long.parseLong(request.getParameter("mobile")));
			e.setPassword(request.getParameter("password"));
			e.setSal(Double.parseDouble(request.getParameter("salary")));
			e.setUsername(request.getParameter("fname").toLowerCase()+"_"+request.getParameter("lname").toLowerCase());
			if(dao.updateEmployee(e))
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("confirm(\"Successfully Updated employee and the username is firstname_lastname \");");
				   out.println("location='Admin.html';");
				   out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Something Went Wrong');");
				   out.println("location='Admin.html';");
				   out.println("</script>");
			}
			break;
		case "/delete":
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			if(dao.deleteEmployee(fname,lname)) {
				out.println("<script type=\"text/javascript\">");
				   out.println("confirm(\"Successfully Deleted employee \");");
				   out.println("location='Admin.html';");
				   out.println("</script>");
			}
			else {
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Enter Details Correctly');");
				   out.println("location='Admin.html';");
				   out.println("</script>");
			}
			break;
		case "/view_all":
			ArrayList<Employee> list=dao.viewAllEmployeess();
			System.out.println(list);
			if(list.size()==0)
				request.setAttribute("reply","No Records are avaliable in the DataBase");
			else
				request.setAttribute("emp_all", list);
			rd.include(request,response);
			break;
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		doPost(request,response);
	}
}
