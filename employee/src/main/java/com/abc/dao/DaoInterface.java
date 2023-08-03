package com.abc.dao;

import java.util.ArrayList;

import com.abc.model.Employee;

public interface DaoInterface {
	public boolean addEmployee(Employee e);
	public boolean deleteEmployee(String fname,String lname);
	public boolean updateEmployee(Employee e);
	public boolean checkLogin(String username,String password);
	public Employee getEmployeeByUsername(String fname,String lname);
	public ArrayList<Employee> viewAllEmployeess();
}
