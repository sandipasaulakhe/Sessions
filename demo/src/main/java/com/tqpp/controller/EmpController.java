package com.tqpp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tqpp.dao.EmployeeRepository;
import com.tqpp.model.Employee;

@Controller

public class EmpController {
	

	@Autowired
	private EmployeeRepository erepo;
	
	
	@GetMapping(value="/")
	public String startpage()
	{
		return "AddEmp";
	}

	@ResponseBody
	@PostMapping(value="/addemp")
	public String addEmployee(@ModelAttribute Employee e1)
	{  
		erepo.save(e1);
		System.out.println(e1);
		return "successsss";
	}
}


