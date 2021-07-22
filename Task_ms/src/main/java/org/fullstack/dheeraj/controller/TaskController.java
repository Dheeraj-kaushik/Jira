package org.fullstack.dheeraj.controller;

import java.util.List;

import javax.validation.Valid;

import org.fullstack.dheeraj.model.Task;
import org.fullstack.dheeraj.service.SubtaskService;
import org.fullstack.dheeraj.service.TaskService;
import org.fullstack.dheeraj.utils.exceptions.DuplicateTaskException;
import org.fullstack.dheeraj.utils.exceptions.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@Autowired
	private SubtaskService subService;
	
	@GetMapping(path = "/get/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<Task> getTask(@PathVariable("id") Long id){
		Task task = service.getTask(id);
		if(task == null) {
			throw new TaskNotFoundException("Task not found with id :"+id);
		}
		return new ResponseEntity<Task>(task , HttpStatus.OK);
	}
	
	@GetMapping(path = "/getAll" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> tasks = service.getAllTasks();
		if(tasks == null) {
			throw new TaskNotFoundException("no tasks created yet");
		}
		return new ResponseEntity<List<Task>>(tasks , HttpStatus.OK);
	}
	
	@GetMapping(path = "/oneProject/{project_id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<Task>> getAllTasksForProject(@PathVariable("project_id") Long project_id){
		System.out.println("communication success");
		List<Task> tasks = service.getFromProjectId(project_id);
		if(tasks == null) {
			throw new TaskNotFoundException("no tasks created yet");
		}
		return new ResponseEntity<List<Task>>(tasks , HttpStatus.OK);
	}
	
	@PostMapping(path = "/save" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> createTask(@RequestBody @Valid Task task){	
		String taskName = service.getTask(task.getName());
		if(taskName != null) {
			throw new DuplicateTaskException("Task with this name already exists");
		}
		service.createTask(task);
		return ResponseEntity.ok().body("Task created successfully");
	}
	
	@PutMapping(path = "/update/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> updateTask(@RequestBody @Valid Task task , @PathVariable("id") Long id){
		Task temp = service.getTask(id);
		if(temp == null) {
			throw new TaskNotFoundException("Task that you want to update does not exist");
		}
		service.updateTask(task , id);
		return ResponseEntity.ok().body("Task updated with id :"+id);
	}
	
	@DeleteMapping(path = "/delete/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> deleteTask(@PathVariable("id")Long id){
		Task task = service.getTask(id);
		if(task == null) {
			throw new TaskNotFoundException("Task that you want to delete does not exist");
		}
		service.delete(id);
		return ResponseEntity.ok().body("Task deleted with id :"+id);
	}
	
	
	
	
	
	
}
