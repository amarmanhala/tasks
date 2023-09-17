package com.example.demo.task;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
   public List<Task> getTasks() {
		return List.of(
			new Task("Buy Milk", "Please buy milk for me", LocalDate.of(2000, Month.JANUARY, 5), "Pending")
		);
	}
}
