package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns= {"/view_first_last"})
public class EmployeeController extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		String path=request.getServletPath();
		DaoInterface dao=new DaoImple();
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		switch(path)
		{
		case "/view_first_last":
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			Employee e=dao.getEmployeeByUsername(fname, lname);
			if(e==null)
				request.setAttribute("reply","No Records are avaliable in the DataBase");
			else
				request.setAttribute("emp_list", e);
			rd.include(request,response);
			break;
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		doGet(request,response);
	}
}
