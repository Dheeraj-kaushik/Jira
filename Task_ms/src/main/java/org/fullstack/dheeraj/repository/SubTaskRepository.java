package org.fullstack.dheeraj.repository;

import org.fullstack.dheeraj.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask , Long> {

}
