package com.abc.Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Dao.AarogyaMethods;
import com.abc.Dao.AarogyaMethodsImple;
import com.abc.Dao.CheckingParameters;
import com.abc.Model.Patient;

public class CheckController extends HttpServlet{

	AarogyaMethods dao=new AarogyaMethodsImple();
	CheckingParameters c=new CheckingParameters();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException
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
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String a=request.getParameter("aadhar_card_number");
		if(dao.deleteMember(a))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Successfully deleted Patient');");
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
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException
	{
		PrintWriter out=response.getWriter();
		String a=request.getParameter("aadhar_card_number");
		if(dao.markRecoverMember(a))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Updated Patient as recovery');");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPut(request,response);
	}
}
