package com.example.demo.task;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
   
	 @Autowired
	 public TaskService(TaskRepository taskRepository) {
   this.taskRepository = taskRepository;
	 }

   public List<Task> getTasks() {
		return taskRepository.findAll();
	}
}
