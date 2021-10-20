package com.tqpp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tqpp.model.Employee;

public class EmployeeRepository extends extends JpaRepository<Employee,Integer>

 {

}
