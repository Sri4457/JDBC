package com.example.sample.service;

import com.example.sample.model.Student;

public interface ServiceInterface {

	public boolean addStudent(Student std);
	public boolean deleteStudent(String stdid);
	public String updateStudent(Student std);
}
