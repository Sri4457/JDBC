package com.example.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.Dto.Response;
import com.example.sample.Repositories.StudentRepo;
import com.example.sample.model.Student;
import com.example.sample.service.ServiceInterface;

@RestController()
public class DemoController {

	@Autowired
	StudentRepo srepo;
	
	@Autowired
	ServiceInterface sinter;
	
	
	@PostMapping("/add")
	public ResponseEntity<Response> addStudent(@RequestBody Student std)
	{
		boolean b=sinter.addStudent(std);
		Response response;
		if(b)
		response=new Response(b,"Something Went Wrong");
		else
			response=new Response(b,"Record added Successfully");
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteStudent(@PathVariable String id)
	{
		Response response;
		boolean b=sinter.deleteStudent(id);
		if(b)
			response=new Response(b,"Something Went Wrong");
			else
				response=new Response(b,"Record deleted Successfully");
			return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody Student std)
	{
		String s=sinter.updateStudent(std);
		return s;
	}
	@GetMapping("/viewall")
	public List<Student> viewAll()
	{
		List<Student> list=srepo.findAll();
		return list;
	}
	
}
