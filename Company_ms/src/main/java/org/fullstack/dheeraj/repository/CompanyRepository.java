package org.fullstack.dheeraj.repository;

import org.fullstack.dheeraj.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company , Long>{

	
	
}
