package org.fullstack.dheeraj.repository;
import java.util.List;

import org.fullstack.dheeraj.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositoryCustom extends JpaRepository<Task , Long>{

	@Query("select t.name from Task t where LOWER(t.name) = LOWER(:name)")
	public String getTask(@Param("name") String name);
	
	@Query("select s from Task s WHERE s.project_id = :project_id")
	public List<Task> get(@Param("project_id") Long project_id);
}
