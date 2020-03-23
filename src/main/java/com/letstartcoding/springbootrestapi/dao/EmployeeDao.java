package com.letstartcoding.springbootrestapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letstartcoding.springbootrestapi.model.Employee;
import com.letstartcoding.springbootrestapi.repository.EmployeeRepository;

@Service
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	// create an employee
	
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	// search all employees
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	// get an employee
	
	public Optional<Employee> findOne(Long empid) {
		return employeeRepository.findById(empid);
	}
	
	// delete an employee 
	
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}

}
