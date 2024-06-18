package com.ibm.service;


import com.ibm.dto.CustomerDTO;
import com.ibm.exception.SBIException;




public interface CustomerService {
	public CustomerDTO getCustomer(Integer customerId) throws SBIException;
	/*
	 * public List<CustomerDTO> getAllCustomers() throws HDFCBankException; public
	 * Integer addCustomer(CustomerDTO customer) throws HDFCBankException; public
	 * void updateCustomer(Integer customerId, String emailId) throws
	 * HDFCBankException; public void deleteCustomer(Integer customerId) throws
	 * HDFCBankException;
	 */
}
