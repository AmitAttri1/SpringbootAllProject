package com.ibm.service;

import com.ibm.dto.CustomerDto;
import com.ibm.exception.HDFException;

public interface CustomerService {
	
	public CustomerDto getCustomer(Integer customerId) throws HDFException;

}
