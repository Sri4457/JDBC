package com.example.sample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {

	
	public Student(String name, String city, String email,String stdid) {
		super();
		this.name = name;
		this.city = city;
		this.email = email;
		this.stdid=stdid;
	}
	public Student() {
		super();
	}
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="cty", nullable=false)
	private String city;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="stdid", nullable=false, unique=true)
	private String stdid;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStdid() {
		return stdid;
	}
	public void setStdid(String stdid) {
		this.stdid = stdid;
	}

	
	
	
}
