package service;

import dto.CustomerDTO;
import exception.HDFbankException;

public interface CustomerService {
	
	
	public  CustomerDTO getCustomer(Integer customerId) throws HDFbankException;

}
