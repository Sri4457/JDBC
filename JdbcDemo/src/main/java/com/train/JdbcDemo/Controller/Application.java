package com.train.JdbcDemo.Controller;

import java.util.List;
import java.util.Scanner;

import com.train.JdbcDemo.Model.Student;
import com.train.JdbcDemo.Dao.DaoImpl;
import com.train.JdbcDemo.Dao.DaoInterface;

public class Application {
Scanner sc=new Scanner(System.in);
DaoInterface dao=new DaoImpl();
	
    public static void main(String[] args) {
	    Application app=new Application();
	    while(true){
	    	System.out.println("1. Add Student");
	    	System.out.println("2. Delete Student");
	    	System.out.println("3. Update Student");
	    	System.out.println("4. Get By id");
	    	System.out.println("5. View All students");
	    	System.out.println("6. Exit");
	    	int option=app.sc.nextInt();
	    	switch(option)
	    	{
	    	case 1:
	    		app.addStudent();
	    		break;
	    	case 2:
	    		app.deleteStudent();
	    		break;
	    	case 3:
	    		app.updateStudent();
	    		break;
	    	case 4:
	    		app.viewById();
	    		break;
	    	case 5:
	    		app.viewAllStudents();
	    		break;
	    	case 6:
	    		System.out.println("Thank you for using");
	    		break;
	    	}
	    	if(option ==6)
	    	{
	    		break;
	    	}
	    }
    }
    
	private void addStudent() {
		Student std=new Student();
	    System.out.println("Enter sid");
	    std.setSid(sc.nextInt());
	    System.out.println("Enter student name");
	    std.setSname(sc.next());
	    System.out.println("Enter marks ");
	    std.setMarks(sc.nextInt());
	    System.out.println("Enter city");
	    std.setCity(sc.next());

	    boolean b=dao.addStudent(std);
	    if(b) {
	        System.out.println("student record added successfully");
	    }
	    else {
	        System.out.println("failed to add student");
	    }
	}
	
	private void deleteStudent() {
		System.out.println("Enter the id");
		int id=sc.nextInt();
		boolean b=dao.deleteStudent(id);
		if(b)
			System.out.println("Student deleted successfully");
		else
			System.out.println("Failed to delete student");
		
	}
	
	private void updateStudent() {
		
		Student std=new Student();
	    System.out.println("Enter id of student to be updated");
	    std.setSid(sc.nextInt());
	    System.out.println("Enter student name to be updated");
	    std.setSname(sc.next());
	    System.out.println("Enter marks of student to be updated");
	    std.setMarks(sc.nextInt());
	    System.out.println("Enter city of student to be updated");
	    std.setCity(sc.next());
	    boolean b=dao.updateStudent(std);
	    if(b)
	    {
	    	System.out.println("Successfully updated");
	    }
	    else {
	    	System.out.println("Failed to Update student details");
	    }
		
	}
	
	private void viewById() {
		System.out.println("Enter Id to get Details");
		int id=sc.nextInt();
		Student s=dao.getStudentById(id);
		System.out.println("The Student id : "+s.getSid()+" The name of student is  : "+s.getSname()+" the city is : "+s.getCity()+" and the student with marks : "+s.getMarks());
		
	}
	
	private void viewAllStudents() {
		List<Student> list=dao.viewAllStudents();
		for(int i=0;i<list.size();i++)
		{
			System.out.println("The Student id : "+list.get(i).getSid()+" The name of student is  : "+list.get(i).getSname()+" the city is : "+list.get(i).getCity()+" and the student with marks : "+list.get(i).getMarks());
		}
		
	}

}