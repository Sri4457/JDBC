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
	    boolean flag=true;
	    while(flag){
	    	flag=app.choices();
	    }
    }
    
    private boolean choices() {
    	boolean flag=true;
    	System.out.println("1. Add Student");
    	System.out.println("2. Delete Student");
    	System.out.println("3. Update Student");
    	System.out.println("4. Get By id");
    	System.out.println("5. View All students");
    	System.out.println("6. View Students Order By name");
    	System.out.println("7. Select Students based city and marks range");
    	System.out.println("8. View Students Order By Marks;");
    	System.out.println("9. Exit");
    	int option=sc.nextInt();
    	switch(option)
    	{
    	case 1:
    		addStudent();
    		break;
    	case 2:
    		deleteStudent();
    		break;
    	case 3:
    		updateStudent();
    		break;
    	case 4:
    		viewById();
    		break;
    	case 5:
    		viewAllStudents();
    		break;
    	case 6:
    		viewAllStudentsByName();
    		break;
    	case 7:
    		viewStudentsByCityMarksRange();
    		break;
    	case 8:
    		viewStudentsByMarks();
    		break;
    	case 9:
    		System.out.println("Thank you for using");
    		break;
    	}
    	if(option ==9)
    	{
    		flag=false;
    	}
    	return flag;
    }
    
	
	private void addStudent() {
		Student std=new Student();
	    System.out.println("Enter sid");
	    std.setSid(sc.nextInt());
	    System.out.println("Enter student name");
	    std.setSname(sc.nextLine());
	    sc.nextLine();
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
	    boolean flag_name=false,flag_marks=false,flag_city=false;
	    while(true)
	    {
	    	if(flag_name==false)
	    		System.out.println("Enter *'name'* to Change Student Name to Be Updated");
	    	if(flag_marks==false)
	    		System.out.println("Enter *'marks'* to Change student marks to be updated");
	    	if(flag_city==false)
	    		System.out.println("Enter *'city'* Change student city to be updated");
	    	System.out.println("Enter *'exit'* to done with the changes");
	    	String option=sc.next();
	    	if(option.equalsIgnoreCase("name"))
	    	{
	    		sc.nextLine();
	    		System.out.println("Enter name");
	    		std.setSname(sc.nextLine());
	    		flag_name=true;
	    	}
	    	if(option.equalsIgnoreCase("marks"))
	    	{
	    		sc.nextLine();
	    		System.out.println("Enter marks of student to be updated");
			    std.setMarks(sc.nextInt());
	    		flag_marks=true;
	    	}
	    	if(option.equalsIgnoreCase("city"))
	    	{
	    		System.out.println("Enter city of student to be updated");
			    std.setCity(sc.next());
	    		flag_city=true;
	    	}
		    if(option.equalsIgnoreCase("exit"))
		    {
		    	System.out.println("Updation done");
		    	break;
		    }
	    }
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
		if(s==null)
			System.out.println("No Record");
		else
		System.out.println("The Student id : "+s.getSid()+" The name of student is  : "+s.getSname()+" the city is : "+s.getCity()+" and the student with marks : "+s.getMarks());
		
	}
	private void viewAllStudents() {
		List<Student> list=dao.viewAllStudents();
		if(list.size()==0)
			System.out.println("No records in database");
		else {
		for(int i=0;i<list.size();i++)
			{
				System.out.println("The Student id : "+list.get(i).getSid()+" The name of student is  : "+list.get(i).getSname()+" the city is : "+list.get(i).getCity()+" and the student with marks : "+list.get(i).getMarks());
			}
		}
		
	}
	
	private void viewAllStudentsByName() {
		List<Student> list=dao.viewAllStudentsByName();
		if(list.size()==0)
			System.out.println("No records in database");
		else {
		for(int i=0;i<list.size();i++)
			{
				System.out.println("The Student id : "+list.get(i).getSid()+" The name of student is  : "+list.get(i).getSname()+" the city is : "+list.get(i).getCity()+" and the student with marks : "+list.get(i).getMarks());
			}
		}
		
	}
	private void viewStudentsByMarks() {
		List<Student> list=dao.viewStudentsOrderByMarks();
		if(list.size()==0)
			System.out.println("No records in database");
		else {
		for(int i=0;i<list.size();i++)
			{
				System.out.println("The Student id : "+list.get(i).getSid()+" The name of student is  : "+list.get(i).getSname()+" the city is : "+list.get(i).getCity()+" and the student with marks : "+list.get(i).getMarks());
			}
		}
		
		
	}

	private void viewStudentsByCityMarksRange() {
		System.out.println("Enter the City");
		String city=sc.next();
		System.out.println("Enter the starting marks");
		int m1=sc.nextInt();
		System.out.println("Enter the ending marks");
		int m2=sc.nextInt();
		List<Student> list=dao.viewStudentsInMarksAndCity(m1, m2, city);
		if(list.size()==0)
			System.out.println("No records in database");
		else {
		for(int i=0;i<list.size();i++)
			{
				System.out.println("The Student id : "+list.get(i).getSid()+" The name of student is  : "+list.get(i).getSname()+" the city is : "+list.get(i).getCity()+" and the student with marks : "+list.get(i).getMarks());
			}
		}
		
		
	}


}