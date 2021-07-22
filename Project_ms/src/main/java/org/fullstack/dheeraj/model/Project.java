package org.fullstack.dheeraj.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Project name cannot be null")
	private String name;
	@NotNull(message = "Project description cannot be null")
	private String description;
	private Date startDate;
	@NotNull(message = "Project status cannot be null")
	private boolean status;
	
	public Project() {
		
	}

	public Project(String name , String description, boolean status) {
		this.name = name;
		this.description = description;
		this.startDate = new Date();
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", status=" + status + "]";
	}
	}
