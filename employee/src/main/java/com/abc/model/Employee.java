package com.abc.model;

import java.sql.Date;

public class Employee {
	String first_name,last_name,gender,address,password,username,email;
	Date age;
	long mobile;
	double sal;
	Date date;
	int id;
	
	public Employee(String first_name, String last_name, String gender, String address, String password,
			String username, String email, Date age, long mobile, double sal) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.address = address;
		this.password = password;
		this.username = username;
		this.email = email;
		this.age = age;
		this.mobile = mobile;
		this.sal = sal;
	}
	public Employee() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAge() {
		return age;
	}
	public void setAge(Date age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	
}
