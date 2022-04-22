package com.manager.service;

import java.util.List;
import com.manager.model.Employee;

public interface EmployeeService {
	
	List<Employee> list();
	Employee add(Employee employee);
	Employee edit(Employee employee);
	void delete(Integer id);
	Employee idList(Integer id);
	
}
