package org.fullstack.dheeraj.model;

import java.util.List;

public class TaskList {

	private List<Task> taskList;
	
	public TaskList() {
		
	}
	
	public TaskList(List<Task> list) {
		this.taskList = list;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	
	
}
