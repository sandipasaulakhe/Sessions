package com.example.controller;
import java.util.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmpRepository;
import com.example.model.Employee;

@RestController


public class EmployeeController {

	@Autowired
	private EmpRepository erepo;
	
	@GetMapping(value="/home")
	public String home()
	{
	return "Welcome developer";
	}
	
	@PostMapping(value="/addEmp")
	public boolean addEmp(@RequestBody Employee e1)
	{
		System.out.println("in addemp"+e1);
	    erepo.save(e1);
		return true;
	}
	
	
	@GetMapping(value="/getEmp/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable int id)
	{
		System.out.println("id="+id);
		Employee e1=erepo.getById(id);
		System.out.println(e1);
		return e1;
	}
	
	
	
	@GetMapping(value="/getAllEmps")
	public List<Employee> getEmployeeById()
	{
		List<Employee> elist=erepo.findAll();
		return elist;
	}
	
	@DeleteMapping(value="/deleteEmp/{id}")
	public boolean deleteByid(@PathVariable int id)
	{
		
		erepo.deleteById(id);
		return true;
	}
	
	@PutMapping(value="/updateEmp")
	public ResponseEntity<Boolean> updateEmp(@RequestBody Employee e1)
	{
	erepo.save(e1);
	return new  ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@GetMapping(value="/getByCity/{city}")
    public ResponseEntity<List<Employee>> getByCity(@PathVariable String city)
    {
		List<Employee> elist= erepo.findByCity(city);
		if(elist.isEmpty())
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		else
			return new  ResponseEntity<List<Employee>>(elist, HttpStatus.OK);
		
    }
	
	
	
	@GetMapping(value="/greatthanSal/{sal}")
    public ResponseEntity<List<Employee>> getByCity(@PathVariable int sal)
    {
		List<Employee> elist= erepo.findBySalaryGreaterThan(sal);
		if(elist.isEmpty())
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		else
			return new  ResponseEntity<List<Employee>>(elist, HttpStatus.OK);
		
    }
	

	
	@GetMapping(value="/sort")
    public List<Employee> getByCity()
    {
		return erepo.sortEmpBysal();
    }
    



}
