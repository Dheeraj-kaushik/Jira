package org.fullstack.dheeraj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "company_e")
@Table(name = "company_entity")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private String website;
	private String email;
	private Long gst_number;
	
	public Company() {
		
	}
	
	public Company(String name , String address , String website , String email , Long gst_number) {
		this.name = name;
		this.address = address;
		this.website = website;
		this.email= email;
		this.gst_number = gst_number;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getGst_number() {
		return gst_number;
	}
	
	public void setGst_number(Long gst_number) {
		this.gst_number = gst_number;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", website=" + website + ", email="
				+ email + ", gst_number=" + gst_number + "]";
	}
}
