package org.fullstack.dheeraj.service;

import java.util.List;

import org.fullstack.dheeraj.model.SubTask;
import org.fullstack.dheeraj.repository.SubTaskRepository;
import org.fullstack.dheeraj.repository.SubtaskRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubtaskService {

	@Autowired
	private SubTaskRepository repo;
	
	@Autowired
	private SubtaskRepositoryCustom rep;
	
	public List<SubTask> getSub(Long id){
		List<SubTask> all = rep.getAll(id);
		return all;
	}
	
	public SubTask getSubtask(Long id) {
		SubTask subtask = repo.findById(id).orElse(null);
		return subtask;
	}
	
	public List<SubTask> getAllSubtasks(){
		List<SubTask> subtask = repo.findAll();
		return subtask;
	}
	
	public void createSubtask(SubTask subtask) {
		repo.save(subtask);
	}
	
	public void updateSubTask(SubTask subtask) {
		SubTask sub = repo.findById(subtask.getId()).orElse(null);
		sub.setName(subtask.getName());
		sub.setDescrption(subtask.getDescrption());
		sub.setCreationDate(subtask.getCreationDate());
		sub.setStatus(subtask.getStatus());
		repo.save(sub);
	}
	
	public void deleteSubtask(Long id) {
		repo.deleteById(id);
	}
	
	public void delete(SubTask subtask) {
		repo.delete(subtask);
	}
	
	
	
	
	
	
	
}
