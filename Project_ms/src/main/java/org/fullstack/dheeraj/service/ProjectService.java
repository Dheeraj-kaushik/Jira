package org.fullstack.dheeraj.service;

import java.util.List;

import org.fullstack.dheeraj.model.Project;
import org.fullstack.dheeraj.repository.ProjectRepository;
import org.fullstack.dheeraj.repository.ProjectRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectService {

	@Autowired
	private ProjectRepository repo;
	
	@Autowired
	private ProjectRepositoryCustom custom;
	
	public void add(Project project) {
		repo.save(project);
	}
	
	public Project getOne(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Project> getAll(){
		return repo.findAll();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public void update(Project project , Long id) {
		Project p = repo.findById(id).orElse(null);
		p.setName(project.getName());
		p.setDescription(project.getDescription());
		p.setStatus(project.getStatus());
		repo.save(p);
	}
	
	public String getCompany(String name) {
		String projectName = custom.getProject(name);
		return projectName;
	}
	
	
}
