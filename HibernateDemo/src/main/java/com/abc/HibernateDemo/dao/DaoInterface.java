package com.abc.HibernateDemo.dao;

import java.util.List;

import com.abc.HibernateDemo.Model.Employee;

public interface DaoInterface {

	void addEmployee(Employee e);
	void deleteEmp(int i);
	Employee getEmployeeById(int i);
	List<Employee> viewAllEmp();
	List<Employee> getByCity(String city);
	List<Employee> getSalRange(double a, double b);
	
}
