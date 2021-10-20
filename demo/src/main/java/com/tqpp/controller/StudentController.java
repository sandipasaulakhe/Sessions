package com.tqpp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tqpp.model.Student;

@RestController

public class StudentController {


	@GetMapping(value="/hi")
	public Student getStud()
	{
		return new Student(1,"Sneha","MCA","P");
		
	}
	
	
	@GetMapping(value="/getAll",produces =MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudent()
	{
		ArrayList<Student> al=new ArrayList<Student>();
		al.add(new Student(1,"Sandipa","BE","P"));
		al.add(new Student(2,"Siya","BE","P"));
		al.add(new Student(3,"Omkar","BE","P"));
		al.add(new Student(4,"Krishna","BE","P"));
		return al;
	}




}
