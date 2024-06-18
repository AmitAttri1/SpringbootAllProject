package com.bhartIT.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public int hashCode() {
		return Objects.hash(customerId, dateOfBirth, emailId, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(name, other.name);
	}
	
	

}
