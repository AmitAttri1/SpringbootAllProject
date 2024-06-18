package com.BharatIT.service;

import java.util.List;

import com.BharatIT.Icici_Bank_Exception.IciciBankException;
import com.BharatIT.dto.CustomerDto;

public interface CustomerService {
	
	public List<CustomerDto> getAllData() throws IciciBankException;
	
	public CustomerDto getData(int customerId) throws IciciBankException;

	public Integer addData(CustomerDto customer) throws IciciBankException;


}
