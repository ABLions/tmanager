package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.model.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
