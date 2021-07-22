package org.fullstack.dheeraj.controller;

import java.util.List;

import javax.validation.Valid;

import org.fullstack.dheeraj.dto.RequestCompanyDTO;
import org.fullstack.dheeraj.dto.ResponseCompanyDTO;
import org.fullstack.dheeraj.model.Company;
import org.fullstack.dheeraj.service.CompanyService;
import org.fullstack.dheeraj.service.EmailService;
import org.fullstack.dheeraj.utils.exception.CompanyNotFoundException;
import org.fullstack.dheeraj.utils.exception.DuplicateCompanyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmailService email;
	
	@GetMapping(path="/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<ResponseCompanyDTO> getCompany(@PathVariable("id") Long id){
		ResponseCompanyDTO res = companyService.getCompany(id);
		if(res == null) {
			throw new CompanyNotFoundException("No Company Found with id :"+id);
		}
		return new ResponseEntity<ResponseCompanyDTO>(res , HttpStatus.OK);
	}
	
	@GetMapping(path = "/getAll" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<ResponseCompanyDTO>> getAllCompanies(){
		List<ResponseCompanyDTO> list = companyService.getAllCompany();
		if(list==null) {
			throw new CompanyNotFoundException("No companies exist");
		}
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(path = "/send" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> save(@RequestBody @Valid RequestCompanyDTO companyDTO){
		String name = companyService.getCompany(companyDTO.getName());
		if(name != null) {
			throw new DuplicateCompanyException("A Company with this name has already been registered");
		}
		companyService.add(companyDTO);
		email.sendEmail(companyDTO.getEmail(), "Thank you for registering on our portal", "Test Mail 1");
		return ResponseEntity.ok().body("Company account created!");
	}
	
	@DeleteMapping(path = "/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Long id){
		ResponseCompanyDTO dto = companyService.getCompany(id);
		if(dto==null) {
			throw new CompanyNotFoundException("Company that you are trying to delete does not exist");
		}
		companyService.deleteById(id);
		return ResponseEntity.ok().body("Company deleted by id: "+id);
	}
	
	@PutMapping(path = "/update/{id}" , consumes = {
			MediaType.APPLICATION_JSON_VALUE
	},
	produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<?> updateCompany(@RequestBody @Valid Company company , @PathVariable("id") Long id){
		ResponseCompanyDTO res = companyService.getCompany(id);
		if(res== null) {
			throw new CompanyNotFoundException("te company that you are trying to update does not exist");
		}
		companyService.update(company , id);
		return ResponseEntity.ok().body("company details updated with company id :"+company.getId());
	}
	
	
	
	
	
}
