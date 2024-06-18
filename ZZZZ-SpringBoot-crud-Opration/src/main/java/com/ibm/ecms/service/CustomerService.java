package com.ibm.ecms.service;

import java.util.List;

import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.exception.HdfcException;

public interface CustomerService {
	
	public CustomerDto getCustomer(Integer customerId) throws HdfcException;
	public List<CustomerDto> getAllCustomer() throws HdfcException; 
	public CustomerDto UpdateCustomer(Integer customerId) throws HdfcException;
	

}
