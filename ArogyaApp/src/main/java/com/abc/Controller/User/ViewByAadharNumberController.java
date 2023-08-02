package com.abc.Controller.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Dao.AarogyaMethodsImple;
import com.abc.Model.Patient;

public class ViewByAadharNumberController extends HttpServlet{

	AarogyaMethodsImple dao=new AarogyaMethodsImple();
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
		Patient rs=dao.viewByAadharCard(request.getParameter("aadhar_card_number"));
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		if(rs==null)
			request.setAttribute("reply","No Records are avaliable with the specific Aadhar Card Number");
		else
			request.setAttribute("emp", rs);
		rd.include(request,response);
	}
}
