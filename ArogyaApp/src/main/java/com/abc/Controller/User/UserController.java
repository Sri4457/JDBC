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

@WebServlet(urlPatterns= {"/view_all","/view_by_acn","/view_by_age","/view_by_city"})
public class UserController extends HttpServlet{
	
	AarogyaMethodsImple dao=new AarogyaMethodsImple();
	protected void goPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String path=request.getServletPath();
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		ArrayList<Patient> list=new ArrayList<>();
		switch(path) {
			case "/view_all":
				list=dao.viewAllMembers();
				if(list.size()==0)
					request.setAttribute("reply","No Records are avaliable in the specific Age Range");
				else
					request.setAttribute("patient_list", list);
				rd.include(request,response);
				break;
			case "/view_by_acn":
				Patient rs=dao.viewByAadharCard(request.getParameter("aadhar_card_number"));
				if(rs==null)
					request.setAttribute("reply","No Records are avaliable with the specific Aadhar Card Number");
				else
					request.setAttribute("patient_list", rs);
				rd.include(request,response);
				break;
			case "/view_by_age":
				list=dao.viewByAge(Integer.parseInt(request.getParameter("age1")), Integer.parseInt(request.getParameter("age2")));
				if(list.size()==0)
					request.setAttribute("reply","No Records are avaliable in the specific Age Range");
				else
					request.setAttribute("patient_list", list);
				rd.include(request,response);
				break;
			case "/view_by_city":
				list=dao.viewByCity(request.getParameter("city"));
				if(list.size()==0)
					request.setAttribute("reply","No Records are avaliable in the specific City");
				else
					request.setAttribute("patient_list", list);
				rd.include(request,response);
				break;
		}
	}
	
}
