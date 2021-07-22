package org.fullstack.dheeraj.repository;

import org.fullstack.dheeraj.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepositoryCustom extends JpaRepository<Company , Long>{

	@Query("select c.name from Company c where LOWER(c.name) = LOWER(:name)")
	String getCompany(@Param("name") String name);
	
}
