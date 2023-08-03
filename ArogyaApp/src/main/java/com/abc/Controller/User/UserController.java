package com.abc.Controller.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Dao.AarogyaMethodsImple;
import com.abc.Model.Patient;

@WebServlet(urlPatterns= {"/view_by_acn"})
public class UserController extends HttpServlet{
	
	AarogyaMethodsImple dao=new AarogyaMethodsImple();
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String path=request.getServletPath();
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		ArrayList<Patient> list=new ArrayList<>();
		switch(path) {
			case "/view_by_acn":
				Patient rs=dao.viewByAadharCard(request.getParameter("aadhar_card_number"));
				if(rs==null)
					request.setAttribute("reply","No Records are avaliable with the specific Aadhar Card Number");
				else
					request.setAttribute("patient", rs);
				rd.include(request,response);
				break;
			
		}
	}
	
}
