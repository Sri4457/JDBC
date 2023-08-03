<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.abc.model.Employee" %>
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
Employee rs=(Employee)request.getAttribute("emp_list");
ArrayList<Employee> list=(ArrayList<Employee>)request.getAttribute("emp_all");
String msg=(String)request.getAttribute("reply");
%>
<%
if(rs!=null)
{
	%>
	<ul class="container">
		<li>The Id : <%=rs.getId() %>
			<li>The Employee First Name : <%=rs.getFirst_name() %></li>
			<li>The Employee Last Name : <%=rs.getLast_name() %></li>
			<li>The Employee Gender<%=rs.getGender()%></li>
			<li>The Employee Address : <%=rs.getAddress() %></li>
			<li>The Employee Email : <%=rs.getEmail() %></li>
			<li>The Employee contact number : <%=rs.getMobile() %></li>
			<li>The Employee Age : <%=rs.getAge() %></li>
			<li>The Employee Salary : <%=rs.getSal() %></li>
			<li>The Employee Date Of Joining : <%=rs.getDate() %></li>
			<li>The Employee User name: <%=rs.getUsername() %></li>
			<li>The Employee Password  : <%=rs.getPassword() %></li>
		</li>
	</ul>
	<%
}
else if(list!=null)
{
	%>
	<ul class="container">
	<%
	for(Employee e:list)
	{
		%>
			<li>The Id : <%=e.getId() %>
			<UL>
				<li>The Employee First Name : <%=e.getFirst_name() %></li>
				<li>The Employee Last Name : <%=e.getLast_name() %></li>
				<li>The Employee Gender<%=e.getGender()%></li>
				<li>The Employee Address : <%=e.getAddress() %></li>
				<li>The Employee Email : <%=e.getEmail() %></li>
				<li>The Employee contact number : <%=e.getMobile() %></li>
				<li>The Employee Age : <%=e.getAge() %></li>
				<li>The Employee Salary : <%=e.getSal() %></li>
				<li>The Employee Date Of Joining : <%=e.getDate() %></li>
				<li>The Employee User name: <%=e.getUsername() %></li>
				<li>The Employee Password  : <%=e.getPassword() %></lI>
			</UL>
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