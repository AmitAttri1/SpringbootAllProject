package com.bhartIT.dto;

import java.util.Date;

public class CustomerDTO {
	
	
	private Integer customerId;
	private String emailId;
	private String name;
	private Date dateOfBirth;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDataOfBirth() {
		return dateOfBirth;
	}
	public void setDataOfBirth(Date dataOfBirth) {
		this.dateOfBirth = dataOfBirth;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", emailId=" + emailId + ", name=" + name + ", dataOfBirth="
				+ dateOfBirth + "]";
	}
	
	
	

}
