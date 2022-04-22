package com.manager.controller;

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

import com.manager.model.Task;
import com.manager.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	TaskService service;
	
	@GetMapping
	public ResponseEntity<List<Task>> list(){
		List<Task> obj = service.list();
		return new ResponseEntity<List<Task>>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Task> add(@RequestBody Task task){
		Task obj = service.add(task);
		return new ResponseEntity<Task>(obj, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Task> edit(@RequestBody Task task){
		Task obj = service.edit(task);
		return new ResponseEntity<Task>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id)throws Exception{
		Task obj = service.idList(id);
		if(obj == null) {
			throw new Exception("Task not found");
		}
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> idList(@PathVariable("id") Integer id)throws Exception{
		Task obj = service.idList(id);
		if(obj == null) {
			throw new Exception("IdTask not found");
		}
		service.delete(id);
		return new ResponseEntity<Task>(obj, HttpStatus.OK);
	}
}
