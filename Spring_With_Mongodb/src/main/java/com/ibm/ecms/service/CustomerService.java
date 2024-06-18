package com.ibm.ecms.service;

import java.util.List;

import com.ibm.ecms.Icici_Bank_Exception.IciciBankException;
import com.ibm.ecms.dto.CustomerDto;

public interface CustomerService {
	
	public List<CustomerDto> getAllData() throws IciciBankException;
	
	public CustomerDto getData(int customerId) throws IciciBankException;

	public Integer addData(CustomerDto customer) throws IciciBankException;


}
