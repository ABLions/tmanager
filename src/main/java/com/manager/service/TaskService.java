package com.manager.service;

import java.util.List;

import com.manager.model.Task;

public interface TaskService {
	List<Task> list();
	Task add(Task task);
	Task edit(Task task);
	void delete(Integer id);
	Task idList(Integer id);
}
