package com.ibm.ecms.service;

import java.util.List;


import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.exception.InfybankException;

public interface CustomerService {
	
	public CustomerDto getCustomer(Integer custmerId)throws InfybankException;
	public List<CustomerDto> getAllCustomers() throws InfybankException;

	

}
