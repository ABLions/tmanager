package com.manager.service.implementation;

import com.manager.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.model.Employee;
import com.manager.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public List<Employee> list() {
		return repository.findAll();
	}

	@Override
	public Employee add(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee edit(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Employee idList(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
