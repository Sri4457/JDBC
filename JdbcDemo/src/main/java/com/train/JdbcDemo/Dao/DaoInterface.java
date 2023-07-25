package com.train.JdbcDemo.Dao;

import java.util.List;

import com.train.JdbcDemo.Model.Student;
public interface DaoInterface {

 

    public boolean addStudent(Student std);
    public boolean deleteStudent(int sid);
    public boolean updateStudent(Student std);
    public Student getStudentById(int sid);
    public List<Student> viewAllStudents();

}

 