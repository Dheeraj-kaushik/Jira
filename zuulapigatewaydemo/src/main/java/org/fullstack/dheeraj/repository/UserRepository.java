package org.fullstack.dheeraj.repository;

import java.util.List;

import org.fullstack.dheeraj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{

	List<User> findByEmail(String email);
	
}
