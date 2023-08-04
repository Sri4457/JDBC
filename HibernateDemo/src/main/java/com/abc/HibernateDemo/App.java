package com.abc.HibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.abc.HibernateDemo.Model.Employee;
import com.abc.HibernateDemo.dao.*;
public class App
{
    Scanner sc=new Scanner(System.in);
    DaoInterface dao=new DaoImpl();
   
    public App() {
    	
    }
    public void addEmployee() {
        Employee e=new Employee();
        System.out.println("Enter Id");
        e.setId(sc.nextInt());
        System.out.println("Enter Name");
        e.setEname(sc.next());
        System.out.println("Enter City");
        e.setCity(sc.next());
        System.out.println("Enter Email");
        e.setEmail(sc.next());
        System.out.println("Enter salary");
        e.setSalary(sc.nextDouble());
        dao.addEmployee(e);
    }
    public void deleteEmployee()
    {
    	System.out.println("Enter id");
    	dao.deleteEmp(sc.nextInt());
    }
    public void viewEmployee()
    {
    	System.out.println("Enter id");
    	Employee e=dao.getEmployeeById(sc.nextInt());
    	System.out.println("Employee id : "+e.getId());
    	System.out.println("Employee Name : "+e.getEname());
    	System.out.println("Employee City : "+e.getCity());
    	System.out.println("Emloyee Email : "+e.getEmail());
    	System.out.println("Employee Salary : "+e.getSalary());
    }
    public void viewAllEmployees()
    {
    	List<Employee> list=dao.viewAllEmp();
    	for(Employee e:list)
    	{
    		System.out.println("Employee id : "+e.getId());
        	System.out.println("Employee Name : "+e.getEname());
        	System.out.println("Employee City : "+e.getCity());
        	System.out.println("Emloyee Email : "+e.getEmail());
        	System.out.println("Employee Salary : "+e.getSalary());
        	System.out.println("====================================");
    	}
    }
    public static void main( String[] args )
    {
        App obj=new App();
        boolean b=true;
        while(b)
        {
        	System.out.println("1. Add Employee");
        	System.out.println("2. Delete Employee");
        	System.out.println("3. View Employee");
        	System.out.println("4. View all Employees");
        	System.out.println("5. view by city");
        	System.out.println("6. Exit");
        	int option=obj.sc.nextInt();
        	switch(option)
        	{
        	case 1:
        		obj.addEmployee();
        		break;
        	case 2:
        		obj.deleteEmployee();
        		break;
        	case 3:
        		obj.viewEmployee();
        		break;
        	case 4:
        		obj.viewAllEmployees();
        		break;
        	case 5:
        		obj.viewByCity();
        	case 6:
        		b=false;
        		System.out.println("Thank You");
        	}
        }
    }
	public void viewByCity() {
		System.out.println("Enter city Name");
		String city=sc.next();
		List<Employee> list=dao.getByCity(city);
    	for(Employee e:list)
    	{
    		System.out.println("Employee id : "+e.getId());
        	System.out.println("Employee Name : "+e.getEname());
        	System.out.println("Employee City : "+e.getCity());
        	System.out.println("Emloyee Email : "+e.getEmail());
        	System.out.println("Employee Salary : "+e.getSalary());
        	System.out.println("====================================");
    	}
	}
}