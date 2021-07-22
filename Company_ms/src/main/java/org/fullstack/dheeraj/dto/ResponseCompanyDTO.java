package org.fullstack.dheeraj.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ResponseCompanyDTO {

	private String name;
	private String website;
	private String address;
	private String email;
	
	public ResponseCompanyDTO() {
		
	}

	public ResponseCompanyDTO(String name, String website, String address , String email) {
		this.name = name;
		this.website = website;
		this.address = address;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ResponseCompanyDTO [name=" + name + ", website=" + website + ", address=" + address + ", email=" + email
				+ "]";
	}
}
