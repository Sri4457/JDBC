package com.abc.Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Dao.AarogyaMethods;
import com.abc.Dao.AarogyaMethodsImple;
import com.abc.Dao.CheckingParameters;
import com.abc.Model.Patient;

@WebServlet(urlPatterns={"/add","/update","/delete","/view_all","/view_by_age","/city"})
public class AdminController extends HttpServlet{

	AarogyaMethods dao=new AarogyaMethodsImple();
	CheckingParameters c=new CheckingParameters();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException
	{
		String path=request.getServletPath();
//		System.out.println(path);
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		ArrayList<Patient> list=new ArrayList<>();

		switch(path) 
		{
		case "/add":
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
			break;
		case "/delete":
			
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
			break;
		case "/update":
			String acn=request.getParameter("aadhar_card_number");
			if(dao.markRecoverMember(acn))
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
			break;
		case "/view_by_age":
			list=dao.viewByAge(Integer.parseInt(request.getParameter("age1")), Integer.parseInt(request.getParameter("age2")));
			if(list.size()==0)
				request.setAttribute("reply","No Records are avaliable in the specific Age Range");
			else
				request.setAttribute("patient_list", list);
			rd.include(request,response);
			break;
		case "/city":
			list=dao.viewByCity(request.getParameter("city"));
			if(list.size()==0)
				request.setAttribute("reply","No Records are avaliable in the specific Age Range");
			else
				request.setAttribute("patient_list", list);
			rd.include(request,response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path=request.getServletPath();
		RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
		ArrayList<Patient> list=new ArrayList<>();
		switch(path)
		{
		case "/view_all":
			list=dao.viewAllMembers();
			if(list.size()==0)
				request.setAttribute("reply","No Records are avaliable in the specific Age Range");
			else
				request.setAttribute("patient_list", list);
			rd.include(request,response);
			break;
		}
	}
}
