package com.manager.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.model.Task;
import com.manager.repository.TaskRepository;
import com.manager.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService{

	@Autowired
	TaskRepository repository;
	@Override
	public List<Task> list() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Task add(Task task) {
		// TODO Auto-generated method stub
		return repository.save(task);
	}

	@Override
	public Task edit(Task task) {
		// TODO Auto-generated method stub
		return repository.save(task);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Task idList(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

}
