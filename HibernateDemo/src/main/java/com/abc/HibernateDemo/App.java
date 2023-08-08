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
        e.setCity(sc.next().toLowerCase());
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
        	System.out.println("=================================");
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
        	System.out.println("6. View in Salary Range");
        	System.out.println("7. Update Employee");
        	System.out.println("8. Exit");
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
        		break;
        	case 6:
        		obj.viewBySalRange();
        		break;
        	case 7:
        		obj.updateEmployee();
        		break;
        	case 8:
        		b=false;
        		System.out.println("Thank You");
        	}
        }
    }
	private void updateEmployee() {
		System.out.println("Enter Id");
		Employee e=new Employee();
		e.setId(sc.nextInt());
		boolean flag_name=false,flag_city=false,flag_email=false,flag_sal=false;
		while(true)
		{
			if(!flag_name)
				System.out.println("Enter **name** to change the Name");
			if(!flag_city)
				System.out.println("Enter **city** to change the City");
			if(!flag_email)
				System.out.println("Enter **email** to change the Email");
			if(!flag_sal)
				System.out.println("Enter **salary** to change the Salary");
			System.out.println("Enter **exit** to Exit Update function");
			String opt=sc.next();
			if(opt.equalsIgnoreCase("name"))
			{
				flag_name=true;
				System.out.println("Enter Name");
				e.setEname(sc.next());
			}
			else if(opt.equalsIgnoreCase("city"))
			{
				flag_city=true;
				System.out.println("Enter City");
				e.setCity(sc.next());
			}
			else if(opt.equalsIgnoreCase("email"))
			{
				flag_email=true;
				System.out.println("Enter Email");
				e.setEmail(sc.next());
			}
			else if(opt.equalsIgnoreCase("salary"))
			{
				flag_sal=true;
				System.out.println("Enter Salary");
				e.setSalary(sc.nextDouble());
			}
			else if(opt.equalsIgnoreCase("exit"))
			{
				break;
			}
		}
		boolean b=dao.updateEmployee(e);
		if(b)
			System.out.println("Updation done");
		else
			System.out.println("Something went wrong");
		
	}
	private void viewBySalRange() {
		System.out.println("Enter the starting salary");
		double a=sc.nextDouble();
		System.out.println("Enter the Ending salary");
		double b=sc.nextDouble();
		List<Employee> list=dao.getSalRange(a, b);
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