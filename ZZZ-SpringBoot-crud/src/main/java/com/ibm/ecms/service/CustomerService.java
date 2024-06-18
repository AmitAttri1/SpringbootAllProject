package com.ibm.ecms.service;

import java.util.List;

import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.exception.INFbankexception;


public interface CustomerService {
	
	public CustomerDto getCustomer(Integer CustomerId ) throws INFbankexception;
	public List<CustomerDto> getAllCustomer() throws INFbankexception;
	public Integer addAllCustomer(CustomerDto customer)throws INFbankexception;
	public void updateCustomer(Integer CustomerId,String emailId) throws INFbankexception;
	public void deleteCustomer(Integer customerId)throws INFbankexception;
	

	


}