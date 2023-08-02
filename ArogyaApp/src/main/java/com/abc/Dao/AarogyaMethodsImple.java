package com.abc.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.abc.Model.Patient;

public class AarogyaMethodsImple  implements AarogyaMethods{
	Connection conn=null;
	PreparedStatement pmt=null;
	
	public AarogyaMethodsImple(){
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost/hospital","root","4457");
			} 
		catch (Exception e) {
				System.out.println(e);
			}
	}
	
	private java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	@Override
	public boolean addMember(Patient p) {
		boolean b=false;
		try 
		{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select aadhar_card_number from patient");
			while(rs.next())
			{
				String a=rs.getString("aadhar_card_number");
				if(p.getAadhar_card_number().equals(a))
				{
					System.out.println("Already member details are present with the give aadhar Card Number\n");
				}
			}
			pmt=conn.prepareStatement("insert into patient(name,gender,aadhar_card_number,city,contact_number,address,guardian_name,guardian_address,guardian_contact_number,status,date_of_admission,age) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pmt.setString(1, p.getName());
			pmt.setString(2,p.getGender());
			pmt.setString(3, p.getAadhar_card_number());
			pmt.setString(4, p.getCity());
			pmt.setString(5, p.getContact_number());
			pmt.setString(6, p.getAddress());
			pmt.setString(7,p.getGuardian_name());
			pmt.setString(8,p.getGuardian_address());
			pmt.setString(9,p.getGuardian_contact_number());
			pmt.setString(10, "Admitted");
			pmt.setDate(11,getCurrentDate());
			pmt.setInt(12,p.getAge());
			int i=pmt.executeUpdate();
			if(i>0)
			b=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return b;
	}
	
	

	@Override
	public ArrayList<Patient> viewAllMembers() 
	{
		ArrayList<Patient> list=new ArrayList<>();
	    try 
	    {
	    	Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from patient");
			while(rs.next())
			{
				Patient p=new Patient();
				p.setAadhar_card_number(rs.getString("aadhar_card_number"));
				p.setAddress(rs.getString("address"));
				p.setAge(rs.getInt("age"));
				p.setCity(rs.getString("city"));
				p.setContact_number(rs.getString("contact_number"));
				p.setDate_of_admission(rs.getDate("date_of_admission"));
				p.setGender(rs.getString("gender"));
				p.setGuardian_address(rs.getString("guardian_address"));
				p.setGuardian_name(rs.getString("guardian_name"));
				p.setGuardian_contact_number(rs.getString("guardian_contact_number"));
				p.setStatus(rs.getString("status"));
				p.setName(rs.getString("name"));
				p.setId(rs.getInt("id"));
				list.add(p);
			}
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    return list;
	}

	@Override
	public Patient viewByAadharCard(String aadhar_card_number) {
		Patient p=null;
		try {
			pmt=conn.prepareStatement("select * from patient where aadhar_card_number=?");
			pmt.setString(1, aadhar_card_number);
			ResultSet rs=pmt.executeQuery();
			if(rs.next())
			{
				p=new Patient();
				p.setAadhar_card_number(rs.getString("aadhar_card_number"));
				p.setAddress(rs.getString("address"));
				p.setAge(rs.getInt("age"));
				p.setCity(rs.getString("city"));
				p.setContact_number(rs.getString("contact_number"));
				p.setDate_of_admission(rs.getDate("date_of_admission"));
				p.setGender(rs.getString("gender"));
				p.setGuardian_address(rs.getString("guardian_address"));
				p.setGuardian_name(rs.getString("guardian_name"));
				p.setGuardian_contact_number(rs.getString("guardian_contact_number"));
				p.setStatus(rs.getString("status"));
				p.setName(rs.getString("name"));
				p.setId(rs.getInt("id"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
	}

	@Override
	public ArrayList<Patient> viewByCity(String city) {
		ArrayList<Patient> list=new ArrayList<>();
		try {
			pmt=conn.prepareStatement("select * from patient where city=?");
			pmt.setString(1, city);
			ResultSet rs=pmt.executeQuery();
			while(rs.next())
			{
				Patient p=new Patient();
				p.setAadhar_card_number(rs.getString("aadhar_card_number"));
				p.setAddress(rs.getString("address"));
				p.setAge(rs.getInt("age"));
				p.setCity(rs.getString("city"));
				p.setContact_number(rs.getString("contact_number"));
				p.setDate_of_admission(rs.getDate("date_of_admission"));
				p.setGender(rs.getString("gender"));
				p.setGuardian_address(rs.getString("guardian_address"));
				p.setGuardian_name(rs.getString("guardian_name"));
				p.setGuardian_contact_number(rs.getString("guardian_contact_number"));
				p.setStatus(rs.getString("status"));
				p.setName(rs.getString("name"));
				p.setId(rs.getInt("id"));
				list.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	@Override
	public ArrayList<Patient> viewByAge(int a1,int a2) {
		ArrayList<Patient> list=new ArrayList<>();
		try {
			pmt=conn.prepareStatement("select * from patient where age between ? and ? ");
			pmt.setInt(1, a1);
			pmt.setInt(2, a2);
			ResultSet rs=pmt.executeQuery();
			while(rs.next())
			{
				Patient p=new Patient();
				p.setAadhar_card_number(rs.getString("aadhar_card_number"));
				p.setAddress(rs.getString("address"));
				p.setAge(rs.getInt("age"));
				p.setCity(rs.getString("city"));
				p.setContact_number(rs.getString("contact_number"));
				p.setDate_of_admission(rs.getDate("date_of_admission"));
				p.setGender(rs.getString("gender"));
				p.setGuardian_address(rs.getString("guardian_address"));
				p.setGuardian_name(rs.getString("guardian_name"));
				p.setGuardian_contact_number(rs.getString("guardian_contact_number"));
				p.setStatus(rs.getString("status"));
				p.setName(rs.getString("name"));
				p.setId(rs.getInt("id"));
				list.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	@Override
	public boolean markRecoverMember(String aadhar_card_number) {
		boolean b=false;
		try {
			pmt=conn.prepareStatement("update patient set status=? where aadhar_card_number=?");
			pmt.setString(1, "Recovered");
			pmt.setString(2, aadhar_card_number);
			int i=pmt.executeUpdate();
			if(i>0)
			{
				b=true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean deleteMember(String aadhar_card_number) {
		boolean b=false;
		try {
			pmt=conn.prepareStatement("delete from patient where aadhar_card_number=?");
			pmt.setString(1, aadhar_card_number);
			int i=pmt.executeUpdate();
			if(i>0)
			{
				b=true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return b;
	}
	
	//Displaying the member details in detailed way
	public void display(Patient rs)
	{
		try {
		System.out.println("The Id : "+rs.getid());
			System.out.println("The Member Name : "+rs.getName());
			System.out.println("The Member Aadhar card number : "+rs.getAadhar_card_number());
			System.out.println("The Member Gender : "+rs.getGender());
			System.out.println("The Member age : "+rs.getAge());
			System.out.println("The Member city : "+rs.getCity());
			System.out.println("The Member address : "+rs.getAddress());
			System.out.println("The Member contact number : "+rs.getContact_number());
			System.out.println("The Member guardian name : "+rs.getGuardian_name());
			System.out.println("The Member guardian address : "+rs.getGuardian_address());
			System.out.println("The Member guardian contact number : "+rs.getGuardian_contact_number());
			System.out.println("The Status of the Patient: "+rs.getStatus());
			System.out.println("The Time when member admitted  : "+rs.getDate_of_admission());
			System.out.println("=========================================================");
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
	}
}
