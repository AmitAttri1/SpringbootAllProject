package com.ibm.ecms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ecms.dto.CustomerDto;
import com.ibm.ecms.exception.InfybankException;
import com.ibm.ecms.service.CustomerService;



@RestController
@RequestMapping(value = "/hdfc")
public class CustomerApi {
	// http://localhost:8080/hdfc/customers
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private Environment environment;

	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer customerId) throws InfybankException {
		CustomerDto customer = customerService.getCustomer(customerId);

		return new ResponseEntity<>(customer, HttpStatus.OK);

	}
	
	@GetMapping(value = "/customertest")
	public ResponseEntity<CustomerDto> getCustomerData() throws InfybankException {
		CustomerDto customer = new  CustomerDto();
		customer.setCustomerId(1);
		customer.setName("amit");
		//customer.setDateOfBirth(null)
		
		return new ResponseEntity<>(customer, HttpStatus.OK);

	}
}
