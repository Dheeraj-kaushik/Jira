package org.fullstack.dheeraj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Task Name cannot be null")
	private String name;
	@NotNull(message = "Task Description cannot be null")
	private String description;
	@NotNull(message = "Task Status cannot be null")
	private boolean status;
	private Long project_id;
	
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST , mappedBy = "task")
	private List<SubTask> subtask;
	
	public Task() {
		
	}

	public Task(String name, String description, boolean status , Long project_id) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.project_id = project_id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<SubTask> getSubtask() {
		return subtask;
	}

	public void setSubtask(List<SubTask> subtask) {
		this.subtask = subtask;
	}
	
	public Long getProject_id() {
		return project_id;
	}

	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}


	public void addSubTask(SubTask sub) {
		if(subtask == null) {
			subtask = new ArrayList<>();
		}
		subtask.add(sub);
		sub.setTask(this);
	}
	
	
	
	
}
