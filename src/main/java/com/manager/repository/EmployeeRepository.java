package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}
