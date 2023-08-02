package com.abc.Controller.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Dao.AarogyaMethods;
import com.abc.Dao.AarogyaMethodsImple;
import com.abc.Model.Patient;

public class ViewPatientsController extends HttpServlet{

	AarogyaMethodsImple dao=new AarogyaMethodsImple();
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
		ArrayList<Patient> list=dao.viewAllMembers();
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		request.setAttribute("emp_all", list);
		rd.include(request,response);
	}
}
