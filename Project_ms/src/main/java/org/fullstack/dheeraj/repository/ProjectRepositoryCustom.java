package org.fullstack.dheeraj.repository;

import org.fullstack.dheeraj.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositoryCustom extends JpaRepository<Project , Long>{

	@Query("select p.name from Project p where LOWER(p.name) = LOWER(:name)")
	String getProject(@Param("name") String name);
	
}
