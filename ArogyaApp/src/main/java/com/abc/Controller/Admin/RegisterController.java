package com.abc.Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Dao.*;
import com.abc.Model.Patient;


public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	AarogyaMethods dao=new AarogyaMethodsImple();
	CheckingParameters c=new CheckingParameters();
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out=response.getWriter();
		Patient p=new Patient();
		p.setName(request.getParameter("name"));
		p.setGender(request.getParameter("gender"));
		p.setCity(request.getParameter("city"));
		p.setAddress(request.getParameter("address"));
		p.setAge(Integer.parseInt(request.getParameter("age")));
		p.setContact_number(request.getParameter("contact_number"));
		p.setAadhar_card_number(request.getParameter("aadhar_card_number"));
		p.setGuardian_name(request.getParameter("guardian_name"));
		p.setGuardian_address(request.getParameter("guardian_address"));
		p.setGuardian_contact_number(request.getParameter("guardian_contact_number"));
		System.out.println(request.getParameter("contact_number") + (request.getParameter("guardian_contact_number")));
		if(c.checkAadhar(p.getAadhar_card_number()) && c.checkMobile(p.getContact_number()) && c.checkMobile(p.getGuardian_contact_number()))
		{
			boolean b=dao.addMember(p);
			if(b)
			{
				out.println("<script type=\"text/javascript\">");
				out.println("confirm(\"Successfully added Patient\");");
				out.println("location='admin.html';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something Went Wrong');");
				out.println("location='admin.html';");
				out.println("</script>");
			}
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something Went Wrong');");
			out.println("location='admin.html';");
			out.println("</script>");
		}
	}
}
