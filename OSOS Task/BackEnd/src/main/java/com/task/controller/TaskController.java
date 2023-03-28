package com.task.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.Holiday;
import com.task.entities.Task;
import com.task.entities.User;
import com.task.payloads.ApiResponse;
import com.task.repository.TaskRepo;
import com.task.repository.UserRepo;
import com.task.service.TaskService;
import com.task.serviceimpl.UserImpl;

@RestController
@RequestMapping("/task")
@CrossOrigin(allowedHeaders = "*")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private UserImpl userImpl;

	@Autowired
	private TaskRepo taskrepo;
	
	@Autowired
	private UserImpl userimpl;

	@PostMapping("/add")
	public ResponseEntity<Task> createTask(@RequestBody Task task) throws Exception {
		
		User userByUsername = this.userimpl.getUserByUsername("NotAssigned");
		task.setUser(userByUsername);
		Task createTask = this.taskService.createTask(task);
		return new ResponseEntity<>(createTask, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{taskId}")
	public ResponseEntity<ApiResponse> deleteTaskById(@PathVariable int taskId) {
		this.taskService.deleteTaskById(taskId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Task is deleted !!!", true), HttpStatus.ACCEPTED);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Task>> getAllTask() {
		List<Task> allTask = this.taskService.getAllTask();
		return new ResponseEntity<List<Task>>(allTask, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getOne/{taskId}")
	public ResponseEntity<Task> getOneTask(@PathVariable int taskId) {
		Task oneTask = this.taskService.getOneTask(taskId);
		return new ResponseEntity<>(oneTask, HttpStatus.ACCEPTED);
	}

	@PutMapping("/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable int taskId, @RequestBody Task task) {
		
		Task updateTask = this.taskService.updateTask(taskId, task);
		return new ResponseEntity<>(updateTask, HttpStatus.ACCEPTED);
	}

	@PostMapping("/tasks/{taskId}")
	public ResponseEntity<Task> createTaskAndUser(@RequestBody Task task , @PathVariable int taskId) throws Exception {
		System.out.println(task.getUser().getUsername());
		System.out.println(task.getTaskId());
		
		Task oneTask = this.taskService.getOneTask(taskId);
		System.out.println(oneTask.toString());
		String username = task.getUser().getUsername();
		System.out.println(username);
		User userByUsername = this.userImpl.getUserByUsername(username);
		oneTask.setUser(userByUsername);
		this.taskrepo.save(oneTask);
		return new ResponseEntity<>(oneTask, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Task>> getUserByTask(@PathVariable int id)
	{
		List<Task> byUser = this.taskService.getByUser(id);
		return new ResponseEntity<List<Task>>(byUser,HttpStatus.ACCEPTED);
	}
}
