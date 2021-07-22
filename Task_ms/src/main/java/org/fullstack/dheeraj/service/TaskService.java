package org.fullstack.dheeraj.service;

import java.util.List;

import org.fullstack.dheeraj.model.Task;
import org.fullstack.dheeraj.repository.TaskRepository;
import org.fullstack.dheeraj.repository.TaskRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskService {

	@Autowired
	private TaskRepository repo;
	
	@Autowired
	private TaskRepositoryCustom custom;
	
	public Task getTask(Long id) {
		Task task = repo.findById(id).orElse(null);
		return task;
	}
	
	public List<Task> getAllTasks(){
		List<Task> tasks = repo.findAll();
		return tasks;
	}
	
	public void createTask(Task task) {
		repo.save(task);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public void updateTask(Task task , Long id) {
		Task toUpdate = repo.findById(id).orElse(null);
		toUpdate.setName(task.getName());
		toUpdate.setDescription(task.getDescription());
		toUpdate.setStatus(task.getStatus());
		repo.save(toUpdate);
	}
	
	public String getTask(String name) {
		String taskName = custom.getTask(name);
		return taskName;
	}
	
	public List<Task> getFromProjectId(Long project_id) {
		List<Task> task = custom.get(project_id);
		return task;
	}
	
	
	
	
	
}
