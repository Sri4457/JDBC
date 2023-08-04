package com.abc.HibernateDemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

	@Override
	public List<Employee> getByCity(String city) {
		Session session=sf.openSession();
		Query q=session.createQuery("from Employee where city= :city_name");
		q.setParameter("city_name", city.toLowerCase());
		List<Employee> el=q.getResultList();
		return el;
	}

	@Override
	public List<Employee> getSalRange(double a, double b) {
		Session s=sf.openSession();
		Query q=s.createQuery("from Employee where salary>= :salary_1 and salary<= :salary_2");
		q.setParameter("salary_1", a);
		q.setParameter("salary_2", b);
		List<Employee> l=q.getResultList();
		s.close();
		return l;
	}

}
