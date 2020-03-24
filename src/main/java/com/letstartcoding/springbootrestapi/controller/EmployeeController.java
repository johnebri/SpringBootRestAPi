package com.letstartcoding.springbootrestapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value="id") Long empid) {
		Optional<Employee> emp = employeeDao.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	// update an employee by emp id
//	@PutMapping("/employees/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid, @Valid @RequestBody Employee empDetails) {
//		
//		// find the employee
//		Employee emp = employeeDao.findOne(empid);
//		
//		if(emp==null) {
//			return ResponseEntity.notFound().build();
//		}
//		emp.setName(empDetails.getName());
//		emp.setDesignation(empDetails.getDesignation());
//		emp.setExpertise(empDetails.getExpertise());
//		
//		Employee updateEmployee = employeeDao.save(emp);
//		return ResponseEntity.ok().body(updateEmployee);
//		
//	}
	
	// delete an employee
	
//	@DeleteMapping("/employees/{id}") 
//	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid) {
//		
//		// find the employee
//		Employee emp = employeeDao.findOne(empid);
//		
//		if(emp == null ) {
//			return ResponseEntity.notFound().build();
//		}
//		employeeDao.delete(emp);
//		return ResponseEntity.ok().build();
//	}
	
	

}
