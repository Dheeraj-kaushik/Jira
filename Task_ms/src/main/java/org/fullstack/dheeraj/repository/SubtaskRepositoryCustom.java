package org.fullstack.dheeraj.repository;

import java.util.List;

import org.fullstack.dheeraj.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtaskRepositoryCustom extends JpaRepository<SubTask , Long>{

	@Query("select s from SubTask s WHERE s.task.id = :id")
	List<SubTask> getAll(@Param("id") Long id);
	
	
}
