package com.ibm.ecms.service;

import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.exception.InfybankException;

public interface CustomerService {
	
	public CustomerDto getCustomer(Integer custmerId)throws InfybankException;

	

}
