package org.fullstack.dheeraj.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.fullstack.dheeraj.model.Pair;
import org.fullstack.dheeraj.model.Project;
import org.fullstack.dheeraj.model.Task;
import org.fullstack.dheeraj.model.TaskList;
import org.fullstack.dheeraj.service.ProjectService;
import org.fullstack.dheeraj.utils.exception.DuplicateProjectException;
import org.fullstack.dheeraj.utils.exception.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	private Pair pair;

	@GetMapping(path = "/getOne/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	}
			)
	public ResponseEntity<Project> getOne(@PathVariable("id") Long id){	
		Project p = service.getOne(id);
		if(p == null) {
			throw new ProjectNotFoundException("Project not found with id :"+id);
		}
		return ResponseEntity.ok().body(p);
	}
	
	@GetMapping(path = "/projectDetails/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	}
			)
	public ResponseEntity<?> projectDetails(@PathVariable("id") Long id){	
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<TaskList> entity = new HttpEntity<TaskList>(new TaskList() , headers);
		
		RestTemplate restTemplate = new RestTemplate();
		TaskList task = restTemplate.exchange("http://localhost:9005/task-service/oneProject/"+id, HttpMethod.GET , entity , TaskList.class).getBody();
		//TaskList task = restTemplate.getForObject("http://localhost:9005/task-service/oneProject/"+id, TaskList.class);
		List<Task> tasks = task.getTaskList();
		System.out.println(tasks);
		Project p = service.getOne(id);
		if(p == null) {
			throw new ProjectNotFoundException("Project not found with id :"+id);
		}
		Pair pair = new Pair(p , tasks);
		return ResponseEntity.ok().body(pair);
	}
	
	@GetMapping(path = "/getAll" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<Project>> getAll(){
		List<Project> p = service.getAll();
		if(p == null) {
			throw new ProjectNotFoundException("No projects exist");
		}
		return ResponseEntity.ok().body(p);
	}
	
	@PostMapping(path = "/save" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> save(@RequestBody @Valid Project project){
		String projectName = service.getCompany(project.getName());
		if(projectName != null) {
			throw new DuplicateProjectException("This project already exists");
		}
		service.add(project);
		return ResponseEntity.ok().body("Project created with id :" + project.getId());
	}
	
	@DeleteMapping(path = "/delete/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		Project p = service.getOne(id);
		if(p==null) {
			throw new ProjectNotFoundException("the project that you are trying to delete does not exist");
		}
		service.delete(id);
		return ResponseEntity.ok().body("Project deleted by id :" + id);
	}
	
	@PutMapping(path = "/update/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> updateProject(@RequestBody @Valid Project project , @PathVariable("id") Long id){
		Project p = service.getOne(id);
		if(p==null) {
			throw new ProjectNotFoundException("the project that you are trying to update does not exist");
		}
		service.update(project, id);
		return ResponseEntity.ok().body("Project updated with id :"+project.getId());
	}
	
	
	
}
