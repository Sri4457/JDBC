<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.Model.Patient" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Patients</title>
<style>
.container{
margin:5%;
background-color:pink;
}
</style>
</head>
<body>
<%
Patient rs=(Patient)request.getAttribute("emp");
ArrayList<Patient> list=(ArrayList<Patient>)request.getAttribute("emp_all");
String msg=(String)request.getAttribute("reply");
%>
<%
if(rs!=null)
{
	%>
	<ul class="container">
		<li>The Id : <%=rs.getid() %>
			<li>The Member Name : <%=rs.getName() %></li>
			<li>The Member Aadhar card number : <%=rs.getAadhar_card_number() %></li>
			<li>The Member Gender : <%=rs.getGender() %></li>
			<li>The Member age : <%=rs.getAge() %></li>
			<li>The Member city : <%=rs.getCity() %></li>
			<li>The Member address : <%=rs.getAddress() %></li>
			<li>The Member contact number : <%=rs.getContact_number() %></li>
			<li>The Member guardian name : <%=rs.getGuardian_name() %></li>
			<li>The Member guardian address : <%=rs.getGuardian_address() %></li>
			<li>The Member guardian contact number : <%=rs.getGuardian_contact_number() %></li>
			<li>The Status of the Patient: <%=rs.getStatus() %></li>
			<li>The Time when member admitted  : <%=rs.getDate_of_admission() %></li>
		</li>
	</ul>
	<%
}
else if(list!=null)
{
	%>
	<ul class="container">
	<%
	for(Patient p:list)
	{
		%>
			<li>The Id : <%=p.getid() %>
				<ul>
					<li>The Member Name : <%=p.getName() %></li>
					<li>The Member Aadhar card number : <%=p.getAadhar_card_number() %></li>
					<li>The Member Gender : <%=p.getGender() %></li>
					<li>The Member age : <%=p.getAge() %></li>
					<li>The Member city : <%=p.getCity() %></li>
					<li>The Member address : <%=p.getAddress() %></li>
					<li>The Member contact number : <%=p.getContact_number() %></li>
					<li>The Member guardian name : <%=p.getGuardian_name() %></li>
					<li>The Member guardian address : <%=p.getGuardian_address() %></li>
					<li>The Member guardian contact number : <%=p.getGuardian_contact_number() %></li>
					<li>The Status of the Patient: <%=p.getStatus() %></li>
					<li>The Time when member admitted  : <%=p.getDate_of_admission() %></li>
				</ul>
			</li>
		
		<%
	}
	%>
	</ul>
	<%
}
else 
{
	%>
	<div class="container">
		<center><b><%=msg %></b></center>
	</div>
	<%
}
%>
</body>
</html>