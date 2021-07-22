package org.fullstack.dheeraj.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RequestCompanyDTO {

	@NotNull(message = "Company name cannot be null")
	@Size(min = 3 , max = 50 , message = "Company name should be between 3-50 characters")
	private String name;
	@NotNull(message = "Company address cannot be null")
	private String address;
	@NotNull(message = "Company website cannot be null")
	private String website;
	@NotNull(message = "Company gst number cannot be null")
	private String gst_number;
	@NotNull(message = "Company email cannot be null")
	private String email;
	
	public RequestCompanyDTO() {
		
	}

	public RequestCompanyDTO(
			@NotNull(message = "Company name cannot be null") @Size(min = 3, max = 50, message = "Company name should be between 3-50 characters") String name,
			@NotNull(message = "Company address cannot be null") String address,
			@NotNull(message = "Company website cannot be null") String website,
			@NotNull(message = "Company gst number cannot be null") String gst_number,
			@NotNull(message = "Company email cannot be null") String email) {
		this.name = name;
		this.address = address;
		this.website = website;
		this.gst_number = gst_number;
		this.email = email;
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

	public String getGst_number() {
		return gst_number;
	}

	public void setGst_number(String gst_number) {
		this.gst_number = gst_number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RequestCompanyDTO [name=" + name + ", address=" + address + ", website=" + website + ", gst_number="
				+ gst_number + ", email=" + email + "]";
	}
}
