package com.abc.HibernateDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.HibernateDemo.Model.Employee;

public class DaoImpl implements DaoInterface{

	SessionFactory sf=null;
	public DaoImpl() {
		sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	@Override
	public void addEmployee(Employee e) {
		Session session=sf.openSession();
        Transaction txn=session.beginTransaction();
        session.save(e);
        txn.commit();
        session.close();
		
	}

	@Override
	public void deleteEmp(int id) {
		Session session=sf.openSession();
        Transaction txn=session.beginTransaction();
        Employee e=session.get(Employee.class,id);
        session.delete(e);;
        txn.commit();
        session.close();
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session=sf.openSession();
		Employee e=session.get(Employee.class, id);
		session.close();
		return e;
	}

	@Override
	public List<Employee> viewAllEmp() {
		Session session=sf.openSession();
		List<Employee> el=session.createQuery("from Employee", Employee.class).getResultList();
		session.close();
		return el;
	}

}
