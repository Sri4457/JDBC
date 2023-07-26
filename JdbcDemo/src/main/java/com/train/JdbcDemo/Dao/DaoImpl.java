package com.train.JdbcDemo.Dao;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.train.JdbcDemo.Model.Student;
public class DaoImpl implements DaoInterface {
    Connection con=null;
    PreparedStatement pstmt=null;

    public DaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","4457");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public boolean addStudent(Student std)  {
       boolean b=false;
       try {
	       pstmt=con.prepareStatement("insert into student values(?,?,?,?)");
	       pstmt.setInt(1, std.getSid());
	       pstmt.setString(2, std.getSname());
	       pstmt.setInt(3, std.getMarks());
	       pstmt.setString(4, std.getCity());
	       int i=pstmt.executeUpdate();
	       if(i>0) {
	           b=true;
	       }
       }
       catch(Exception e) {
           System.out.println(e);
       }
        return b;
    }
    
	@Override
	public boolean deleteStudent(int sid) {
		boolean b=false;
		try {
			pstmt=con.prepareStatement("delete from student where sid=?");
			pstmt.setInt(1, sid);
			int i=pstmt.executeUpdate();
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
	public boolean updateStudent(Student std) {
		boolean b=false;
		try {
			pstmt=con.prepareStatement("update student set name=?, marks=?, city=? where sid=?");
			pstmt.setString(1, std.getSname());
			pstmt.setInt(2, std.getMarks());
			pstmt.setString(3, std.getCity());
			pstmt.setInt(4,std.getSid());
			int i=pstmt.executeUpdate();
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
	public Student getStudentById(int sid) {
		Student s=null;
		try {
			pstmt=con.prepareStatement("select * from student where sid=?");
			pstmt.setInt(1, sid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				s=new Student();
				s.setCity(rs.getString("city"));
				s.setSname(rs.getString("name"));
				s.setSid(sid);
				s.setMarks(rs.getInt("marks"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}

	@Override
	public List<Student> viewAllStudents() {
		List<Student> list=new ArrayList<>();
		try {
			pstmt=con.prepareStatement("select * from student");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setCity(rs.getString("city"));
				s.setSname(rs.getString("name"));
				s.setSid(rs.getInt("sid"));
				s.setMarks(rs.getInt("marks"));
				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	
}