package com.example.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.Repositories.StudentRepo;
import com.example.sample.model.Student;

@Service
public class ServiceImpl implements ServiceInterface{

	@Autowired
	StudentRepo srepo;
	
	@Override
	public boolean addStudent(Student std) {
		boolean msg;
		try
		{
			srepo.save(std);
			msg=false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			msg=true;
		}
		return msg;
	}

	@Override
	public boolean deleteStudent(String stdid) {
		boolean msg;
		try
		{
			srepo.delete(srepo.findById(getId(stdid)).get());
			msg=false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			msg=true;
		}
		return msg;
	}

	public long getId(String stdid)
	{
		return srepo.findByStdid(stdid);
	}

	@Override
	public String updateStudent(Student std) {
		long id=srepo.findByStdid(std.getStdid());
		Optional<Student> s1=srepo.findById(id);
		Student s=s1.get();
		if(std.getCity()!=null)
		s.setCity(std.getCity());
		if(std.getEmail()!=null)
		s.setEmail(std.getEmail());
		if(std.getName()!=null)
		s.setName(std.getName());
		if(std.getStdid()!=null)
		s.setStdid(std.getStdid());
		String msg;
		try
		{
			srepo.save(s);
			msg="Successfully Updated";
		}
		catch(Exception e)
		{
			System.out.println(e);
			msg="Something went wrong";
		}
		return msg;
	}
}
