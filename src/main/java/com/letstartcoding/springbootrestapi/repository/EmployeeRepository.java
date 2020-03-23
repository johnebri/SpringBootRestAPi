package com.letstartcoding.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letstartcoding.springbootrestapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	

}
