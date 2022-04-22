package com.manager.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manager.model.Employee;
import com.manager.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> list(){
		List<Employee> obj = service.list();
		return new ResponseEntity<List<Employee>>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> add(@RequestBody Employee employee){
		Employee obj = service.add(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEmployee()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<Employee> edit(@RequestBody Employee employee){
		Employee obj = service.edit(employee);
		return new ResponseEntity<Employee>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception{
		Employee obj = service.idList(id);
		if(obj == null) {
			throw new Exception("Task not found");
		}
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> idList(@PathVariable("id") Integer id)throws Exception{
		Employee obj = service.idList(id);
		if(obj == null) {
			throw new Exception("IdTask not found");
		}
		service.delete(id);
		return new ResponseEntity<Employee>(obj, HttpStatus.OK);
	}
}
