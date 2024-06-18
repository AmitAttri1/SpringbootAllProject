package com.bhartIT.sevice;

import java.util.List;

import com.bhartIT.SBIException.SbiException;
import com.bhartIT.dto.CustomerDTO;

public interface CustomerService {
	
	public CustomerDTO getEmployee(Integer customerId) throws SbiException;
	public List<CustomerDTO> getAllEmployee() throws SbiException;
	public Integer addEmployee(CustomerDTO customer) throws SbiException;
	public void  deletetEmployee(Integer customerId) throws SbiException;
	public void  updateEmployee(Integer customerId, String name) throws SbiException;
	
	
	

}
