package com.abc.Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.Dao.AarogyaMethods;
import com.abc.Dao.AarogyaMethodsImple;

public class DeleteController extends HttpServlet{

	AarogyaMethods dao=new AarogyaMethodsImple();
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		PrintWriter out=response.getWriter();
		String a=request.getParameter("aadhar_card_number");
		if(dao.deleteMember(a))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("confirm(\"Successfully Deleted Patient\");");
			out.println("location='admin.html';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('No Patient with the specific Aadhar Card Number');");
			out.println("location='admin.html';");
			out.println("</script>");
		}
	}
	
}
