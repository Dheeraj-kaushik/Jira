package org.fullstack.dheeraj.repository;

import org.fullstack.dheeraj.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	
	
}
