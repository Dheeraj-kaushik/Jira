package org.fullstack.dheeraj.service;

import java.util.ArrayList;
import java.util.List;

import org.fullstack.dheeraj.dto.RequestCompanyDTO;
import org.fullstack.dheeraj.dto.ResponseCompanyDTO;
import org.fullstack.dheeraj.model.Company;
import org.fullstack.dheeraj.repository.CompanyRepository;
import org.fullstack.dheeraj.repository.CompanyRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyService {

	@Autowired
	private CompanyRepository repo;
	
	@Autowired
	private CompanyRepositoryCustom cust;

	public void add(RequestCompanyDTO dto) {
		repo.save(toEntity(dto));
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public List<ResponseCompanyDTO> getAllCompany(){
		List<Company> list = repo.findAll();
		List<ResponseCompanyDTO> res = new ArrayList<>();
		for(Company c : list) {
			ResponseCompanyDTO dto = toDTO(c);
			res.add(dto);
		}
		return res;
		
	}
	
	public void update(Company company , Long id) {
		Company c = repo.findById(id).orElseThrow(null);
		c.setName(company.getName());
		c.setAddress(company.getAddress());
		c.setWebsite(company.getWebsite());
		c.setEmail(company.getEmail());
		c.setGst_number(company.getGst_number());
		repo.save(c);
	}
	
	public ResponseCompanyDTO getCompany(Long id) {
//		Optional<Company> company = repo.findById(id);
//        return company.orElseThrow(() -> new CompanyNotFoundException("Couldn't find a Dog with id: " + id));
		Company company = repo.findById(id).orElse(null);
		return toDTO(company);
	}
	
	public String getCompany(String name) {
		String companyName = cust.getCompany(name);
		return companyName;
	}
	
	public ResponseCompanyDTO toDTO(Company company) {
		ResponseCompanyDTO res = new ResponseCompanyDTO();
		res.setName(company.getName());
		res.setAddress(company.getAddress());
		res.setWebsite(company.getWebsite());
		res.setEmail(company.getEmail());
		return res;
	}
	
	public Company toEntity(RequestCompanyDTO dto) {
		Company entity = new Company();
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setWebsite(dto.getWebsite());
		entity.setEmail(dto.getEmail());
		entity.setGst_number(Long.parseLong(dto.getGst_number()));
		return entity;
	}
	
}
