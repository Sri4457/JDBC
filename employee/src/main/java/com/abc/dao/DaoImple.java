package com.abc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abc.model.Employee;

public class DaoImple implements DaoInterface
{
	Connection conn=null;
	public DaoImple(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/employee","root","4457");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	private java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	@Override
	public boolean addEmployee(Employee e) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into emp(first_name,last_name,gender,DOB,address,mobile,salary,password,date_of_join,email,username) values(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, e.getFirst_name());
			pst.setString(2, e.getLast_name());
			pst.setString(3, e.getGender());
			pst.setDate(4, e.getAge());
			pst.setString(5, e.getAddress());
			pst.setLong(6,e.getMobile());
			pst.setDouble(7,e.getSal());
			pst.setString(8,e.getPassword());
			pst.setDate(9,getCurrentDate());
			pst.setString(10, e.getEmail());
			pst.setString(11, e.getUsername());
			int i=pst.executeUpdate();
			if(i>0)
			{
				return true;
			}
		} catch (SQLException e1) {
			System.out.println(e1);
		}
		
		return false;
	}

	@Override
	public boolean deleteEmployee(String fname, String lname) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from emp where username=?");
			pst.setString(1, (fname.toLowerCase()+"_"+lname.toLowerCase()));
			int i=pst.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean checkLogin(String username, String password) {
		try {
			PreparedStatement pst=conn.prepareStatement("select * from emp where username=? and password=?");
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;

	}

	@Override
	public boolean updateEmployee(Employee e) {
		Employee emp=getEmployeeByUsername(e.getFirst_name(),e.getLast_name());
		try {
			if(e.getFirst_name()!=null)
			{
				emp.setFirst_name(e.getFirst_name());
			}
			if(e.getLast_name()!=null)
			{
				emp.setLast_name(e.getLast_name());;
			}
			if(e.getGender()!=null)
			{
				emp.setGender(e.getGender());
			}
			if(e.getAge()!=null)
			{
				emp.setAge(e.getAge());
			}
			if(e.getAddress()!=null)
			{
				emp.setAddress(e.getAddress());
			}
			if(e.getMobile()!=0)
			{
				emp.setMobile(e.getMobile());
			}
			if(e.getSal()!=0)
			{
				emp.setSal(e.getSal());
			}
			if(e.getPassword()!=null)
			{
				emp.setPassword(e.getPassword());
			}
			if(e.getEmail()!=null)
			{
				emp.setEmail(e.getEmail());
			}
			PreparedStatement pst=conn.prepareStatement("update emp set first_name=?, last_name=?,gender=?,DOB=?,address=?,mobile=?,salary=?,password=?,email=? where username=?");
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getGender());
			pst.setDate(4, emp.getAge());
			pst.setString(5, emp.getAddress());
			pst.setLong(6,emp.getMobile());
			pst.setDouble(7,emp.getSal());
			pst.setString(8,emp.getPassword());
			pst.setString(9, emp.getEmail());
			pst.setString(10, emp.getUsername());
			int i=pst.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		return false;
	}

	@Override
	public Employee getEmployeeByUsername(String fname, String lname) {
		Employee emp=null;
		try {
			PreparedStatement pst=conn.prepareStatement("select * from emp where username=?");
			pst.setString(1, fname+"_"+lname);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirst_name(fname);
				emp.setLast_name(lname);
				emp.setAge(rs.getDate("dob"));
				emp.setAddress(rs.getString("address"));
				emp.setGender(rs.getString("gender"));
				emp.setMobile(rs.getLong("mobile"));
				emp.setPassword(rs.getString("password"));
				emp.setSal(rs.getDouble("salary"));
				emp.setUsername(rs.getString("username"));
				emp.setEmail(rs.getString("email"));
				emp.setDate(rs.getDate("date_of_joining"));
				
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return emp;
	}
	@Override
	public ArrayList<Employee> viewAllEmployeess() {
		ArrayList<Employee> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("select * from emp where id!=1 ");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Employee emp=new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirst_name(rs.getString("first_name"));
				emp.setLast_name(rs.getString("last_name"));
				emp.setAge(rs.getDate("dob"));
				emp.setAddress(rs.getString("address"));
				emp.setGender(rs.getString("gender"));
				emp.setMobile(rs.getLong("mobile"));
				emp.setPassword(rs.getString("password"));
				emp.setSal(rs.getDouble("salary"));
				emp.setUsername(rs.getString("username"));
				emp.setEmail(rs.getString("email"));
				emp.setDate(rs.getDate("date_of_join"));
				list.add(emp);
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	
}
