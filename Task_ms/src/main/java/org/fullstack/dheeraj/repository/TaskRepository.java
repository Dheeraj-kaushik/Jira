package org.fullstack.dheeraj.repository;

import org.fullstack.dheeraj.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task , Long>{

}
