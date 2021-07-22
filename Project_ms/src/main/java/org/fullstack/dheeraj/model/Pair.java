package org.fullstack.dheeraj.model;

import java.util.List;

public class Pair {

	Project project;
	List<Task> task;
	
	public Pair() {
		
	}
	
	public Pair(Project project , List<Task> task) {
		this.project = project;
		this.task = task;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}
	
	
	
}
