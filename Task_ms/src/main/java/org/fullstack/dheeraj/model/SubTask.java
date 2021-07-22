package org.fullstack.dheeraj.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SubTask {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String descrption;
	private boolean status;
	private Date creationDate;
	
	@ManyToOne()
	@JoinColumn(name = "Task_id")
	private Task task;

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

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	public SubTask() {
		
	}

	public SubTask(String name, String descrption, boolean status) {
		this.name = name;
		this.descrption = descrption;
		this.status = status;
		this.creationDate = new Date();
	}

	@Override
	public String toString() {
		return "SubTask [id=" + id + ", name=" + name + ", descrption=" + descrption + ", status=" + status
				+ ", creationDate=" + creationDate + ", task=" + task + "]";
	}
	
}
