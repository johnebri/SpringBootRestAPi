package com.letstartcoding.springbootrestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letstartcoding.springbootrestapi.dao.EmployeeDao;
import com.letstartcoding.springbootrestapi.model.Employee;

@Controller
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	// save an employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return  employeeDao.save(emp);
	}
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}
	
	// get employee by id
	@GetMapping("/notes/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value="id") Long empid) {
		Optional<Employee> emp = employeeDao.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	// 
	
	

}
